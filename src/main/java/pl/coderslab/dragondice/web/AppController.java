package pl.coderslab.dragondice.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dragondice.domain.*;
import pl.coderslab.dragondice.mechanics.AbilityScoreSum;
import pl.coderslab.dragondice.mechanics.ModifiersDefiner;
import pl.coderslab.dragondice.repository.*;
import pl.coderslab.dragondice.service.scoreIncrease.ScoreIncreaseService;
import pl.coderslab.dragondice.service.userCharacter.UserCharacterService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Validated
@RequestMapping("/app")
public class AppController {
    private final UserCharacterRepository userCharacterRepository;
    private final RaceRepository raceRepository;
    private final FeatRepository featRepository;
    private final BackgroundRepository backgroundRepository;
    private final UserCharacterService userCharacterService;
    private final UserRepository userRepository;
    private final ScoreIncreaseRepository scoreIncreaseRepository;
    private final ScoreIncreaseService scoreIncreaseService;

    private final int baseTen = 10;
    private List<Feats> featsList;

    public AppController(UserCharacterRepository userCharacterRepository,
                         RaceRepository raceRepository, FeatRepository featRepository,
                         BackgroundRepository backgroundRepository, UserCharacterService userCharacterService,
                         UserRepository userRepository, ScoreIncreaseRepository scoreIncreaseRepository, ScoreIncreaseService scoreIncreaseService) {

        this.userCharacterRepository = userCharacterRepository;
        this.raceRepository = raceRepository;
        this.featRepository = featRepository;
        this.backgroundRepository = backgroundRepository;
        this.userCharacterService = userCharacterService;
        this.userRepository = userRepository;
        this.scoreIncreaseRepository = scoreIncreaseRepository;
        this.scoreIncreaseService = scoreIncreaseService;
    }

    @GetMapping("/select")
    public String charSelect(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userCharacter", userCharacterRepository.findAllByUserId(user.getId()));
        model.addAttribute("userName", user.getUserName());
        return "/app/characterSelect";
    }

    @GetMapping("/character-sheet/{id}")
    public String charSheet(Model model, @PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());

        UserCharacter userCharacter = userCharacterRepository.findById(id).get();
        ScoreIncrease abilityIncrease = scoreIncreaseRepository.findByCharacterId(id).get();

        AbilityScoreSum abilityScoreSum = new AbilityScoreSum(userCharacterRepository, scoreIncreaseRepository);

        model.addAttribute("userCharacter", userCharacter);
        model.addAttribute("scoreIncrease", abilityIncrease);

        model.addAttribute("strMod", ModifiersDefiner.abilityModifier(abilityScoreSum.strAbilityScore(id)));
        model.addAttribute("dexMod", ModifiersDefiner.abilityModifier(abilityScoreSum.dexAbilityScore(id)));
        model.addAttribute("conMod", ModifiersDefiner.abilityModifier(abilityScoreSum.conAbilityScore(id)));
        model.addAttribute("intMod", ModifiersDefiner.abilityModifier(abilityScoreSum.intAbilityScore(id)));
        model.addAttribute("wisMod", ModifiersDefiner.abilityModifier(abilityScoreSum.wisAbilityScore(id)));
        model.addAttribute("chaMod", ModifiersDefiner.abilityModifier(abilityScoreSum.chaAbilityScore(id)));

        model.addAttribute("armorClass", baseTen + ModifiersDefiner.abilityModifier(abilityScoreSum.dexAbilityScore(id)));

        model.addAttribute("passivePerception", baseTen + ModifiersDefiner.abilityModifier(abilityScoreSum.wisAbilityScore(id)));
        model.addAttribute("passiveInvestigation", baseTen + ModifiersDefiner.abilityModifier(abilityScoreSum.intAbilityScore(id)));
        model.addAttribute("passiveInsight", baseTen + ModifiersDefiner.abilityModifier(abilityScoreSum.wisAbilityScore(id)));

        return "/app/characterSheet";
    }
    @GetMapping("/character-creator")
    public String charCreator(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("user", user.getId());
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("Race", raceRepository.findAll());
        model.addAttribute("Feats", featRepository.findAll());
        model.addAttribute("Background", backgroundRepository.findAll());
        model.addAttribute("userCharacter", new UserCharacter());
        return "/app/characterCreator";
    }

    @GetMapping("/character-creator-result")
    public String charCreatorResult(@Valid UserCharacter userCharacter, BindingResult result, ScoreIncrease scoreIncrease,
                                    @RequestParam long userId, @RequestParam String featFour, @RequestParam String featEight){
        if (result.hasErrors()){
            return "redirect:/app/character-creator/";
        }

        User findUser = userRepository.findById(userId).get();
        featsList = new ArrayList<>();
        if(featFour.isBlank() && featEight.isBlank()){
            userCharacter.setFeats(featsList);
        }else if(featEight.isBlank()){
            featsList.add(featRepository.findById(Long.parseLong(featFour)).get());
            userCharacter.setFeats(featsList);
        }else if(featFour.isBlank()){
            featsList.add(featRepository.findById(Long.parseLong(featEight)).get());
            userCharacter.setFeats(featsList);
        }else {
            featsList.add(featRepository.findById(Long.parseLong(featEight)).get());
            featsList.add(featRepository.findById(Long.parseLong(featFour)).get());
            userCharacter.setFeats(featsList);
        }
        userCharacter.setUser(findUser);
        userCharacterService.saveUserCharacter(userCharacter);
        scoreIncrease.setUserCharacter(userCharacter);
        scoreIncreaseService.saveScoreIncrease(scoreIncrease);

        return "redirect:/app/select";
    }
    @GetMapping("/character-editor/{id}")
    public String charEdit(Model model, @PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("user", user.getId());
        model.addAttribute("Race", raceRepository.findAll());
        model.addAttribute("Feats", featRepository.findAll());
        model.addAttribute("Background", backgroundRepository.findAll());
        model.addAttribute("userCharacter", userCharacterRepository.findById(id).get());

        featsList = userCharacterRepository.findById(id).get().getFeats();
        model.addAttribute("characterFeatName", featsList.stream()
                .map(e -> e.getFeatName()).toArray());
        model.addAttribute("characterFeatId", featsList.stream()
                .map(e -> e.getId()).toArray());

        ScoreIncrease abilityIncrease = scoreIncreaseRepository.findByCharacterId(id).get();
        model.addAttribute("scoreIncrease", abilityIncrease);

        return "/app/characterEditor";
    }
    @GetMapping("/character-editor-result")
    public String charEditResult(@Valid UserCharacter userCharacter, BindingResult result, ScoreIncrease newIncrease,
                                 @RequestParam long id, @RequestParam long userId, @RequestParam String featFour,
                                 @RequestParam String featEight){
        if (result.hasErrors()) {
            return "redirect:/app/character-editor/" + id;
        }

        featsList = new ArrayList<>();
        if(featFour.isBlank() && featEight.isBlank()){
            userCharacter.setFeats(featsList);
        }else if(featEight.isBlank()){
            featsList.add(featRepository.findById(Long.parseLong(featFour)).get());
            userCharacter.setFeats(featsList);
        }else if(featFour.isBlank()){
            featsList.add(featRepository.findById(Long.parseLong(featEight)).get());
            userCharacter.setFeats(featsList);
        }else {
            featsList.add(featRepository.findById(Long.parseLong(featEight)).get());
            featsList.add(featRepository.findById(Long.parseLong(featFour)).get());
            userCharacter.setFeats(featsList);
        }

        Optional<User> findingUser = userRepository.findById(userId);
        Optional<ScoreIncrease> existing = scoreIncreaseRepository.findByCharacterId(id);

        ScoreIncrease scoreIncrease = existing.isPresent()
                ? newIncrease.cloneWithOriginalId(existing.get())
                : newIncrease;

        userCharacter.setUser(findingUser.get());
        userCharacterService.editUserCharacter(userCharacter);
        scoreIncrease.setUserCharacter(userCharacter);
        scoreIncreaseService.editScoreIncrease(scoreIncrease);
        return "redirect:/app/select";

    }
    @GetMapping("/character-delete/{id}")
    public String charDelete(Model model, @PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("userCharacter", userCharacterRepository.findById(id).get());
        return "/app/characterDelete";
    }

    /*Due to approach to this problem, character is being deleted as orphan of it's score increase. It should not cause
    any problems since every character must have their increases even if they are just 0s. It will be changed in the
    future during later developement for something more efficient. */
    @GetMapping("/character-delete-result/{id}")
    public String charDeleteResult(@PathVariable long id){
        scoreIncreaseService.deleteByUserCharacterId(id);
        return "redirect:/app/select";
    }
}
