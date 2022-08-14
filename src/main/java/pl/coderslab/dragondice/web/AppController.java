package pl.coderslab.dragondice.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dragondice.domain.*;
import pl.coderslab.dragondice.mechanics.ModifiersDefiner;
import pl.coderslab.dragondice.repository.*;
import pl.coderslab.dragondice.service.scoreIncrease.ScoreIncreaseService;
import pl.coderslab.dragondice.service.userCharacter.UserCharacterService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
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
    private final String CharacterDataErrorMsg = "Please, fill your character's data properly :)";

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

    //Attributes passed from line 73 to 84 could be also pushed to front and calculated by JS...
    //... but there is no time before deadline to remake it into Js script
    @GetMapping("/character-sheet/{id}")
    public String charSheet(Model model, @PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());

        UserCharacter userCharacter = userCharacterRepository.findById(id).get();
        Optional<ScoreIncrease> ai = scoreIncreaseRepository.findByCharacterId(id);

        ScoreIncrease abilityIncrease = ai.isPresent() ? ai.get() : new ScoreIncrease(0,0,0,0,0,0);

        model.addAttribute("userCharacter", userCharacter);
        model.addAttribute("scoreIncrease", abilityIncrease);

        model.addAttribute("strMod",
                ModifiersDefiner.abilityModifier(userCharacter.getStrAbility() + abilityIncrease.getStrIncreaseFour()));
        model.addAttribute("dexMod",
                ModifiersDefiner.abilityModifier(userCharacter.getDexAbility() + abilityIncrease.getDexIncreaseFour()));
        model.addAttribute("conMod",
                ModifiersDefiner.abilityModifier(userCharacter.getConAbility() + abilityIncrease.getConIncreaseFour()));
        model.addAttribute("intMod",
                ModifiersDefiner.abilityModifier(userCharacter.getIntAbility() + abilityIncrease.getIntIncreaseFour()));
        model.addAttribute("wisMod",
                ModifiersDefiner.abilityModifier(userCharacter.getWisAbility() + abilityIncrease.getWisIncreaseFour()));
        model.addAttribute("chaMod",
                ModifiersDefiner.abilityModifier(userCharacter.getChaAbility() + abilityIncrease.getChaIncreaseFour()));

        model.addAttribute("armorClass",
                baseTen + ModifiersDefiner.abilityModifier(userCharacter.getDexAbility()));

        model.addAttribute("passivePerception",
                baseTen + ModifiersDefiner.abilityModifier(userCharacter.getWisAbility()));
        model.addAttribute("passiveInvestigation",
                baseTen + ModifiersDefiner.abilityModifier(userCharacter.getIntAbility()));
        model.addAttribute("passiveInsight",
                baseTen + ModifiersDefiner.abilityModifier(userCharacter.getWisAbility()));

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
    @GetMapping("/character-creator-correction")
    public String charCreatorWithError(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("user", user.getId());
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("Race", raceRepository.findAll());
        model.addAttribute("Feats", featRepository.findAll());
        model.addAttribute("Background", backgroundRepository.findAll());
        model.addAttribute("userCharacter", new UserCharacter());
        model.addAttribute("errorMsg", CharacterDataErrorMsg);
        return "/app/characterCreator";
    }
    @GetMapping("/character-creator-result")
    public String charCreatorResult(@Valid UserCharacter userCharacter,@Valid ScoreIncrease scoreIncrease, BindingResult result,
                                    @RequestParam String feats, @RequestParam long userId){

        User findUser = userRepository.findById(userId).get();
        if (result.hasErrors()){
            return "redirect:/app/character-creator-correction";
        }
        if (userCharacter.getFeats().isEmpty()){
            userCharacter.setUser(findUser);
            userCharacterService.saveUserCharacter(userCharacter);
            scoreIncrease.setUserCharacter(userCharacter);
            scoreIncreaseService.saveScoreIncrease(scoreIncrease);
        }else { //TODO REMINDER ABOUT ALL FEATS IMPLEMENTATION AND MODIFICATION OF THIS PART \/
            Optional<Feats> feat = featRepository.findById(Long.parseLong(feats));
            List<Feats> featsList = new ArrayList<>();
            featsList.add(feat.get());
            userCharacter.setUser(findUser);
            userCharacterService.saveUserCharacter(userCharacter);
        }
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

        List<Feats> featsList = userCharacterRepository.findById(id).get().getFeats();
        model.addAttribute("characterFeatName", featsList.stream()
                .map(e -> e.getFeatName())
                .collect(Collectors.joining()));
        model.addAttribute("characterFeatId", featsList.stream()
                .map(e -> e.getId()).toArray());

        ScoreIncrease abilityIncrease = scoreIncreaseRepository.findByCharacterId(id).get();
        model.addAttribute("scoreIncrease", abilityIncrease);

        return "/app/characterEditor";
    }
    @GetMapping("/character-editor-correction/{id}")
    public String charEditWithError(Model model, @PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("user", user.getId());
        model.addAttribute("Race", raceRepository.findAll());
        model.addAttribute("Feats", featRepository.findAll());
        model.addAttribute("Background", backgroundRepository.findAll());
        model.addAttribute("userCharacter", userCharacterRepository.findById(id).get());
        model.addAttribute("errorMsg", CharacterDataErrorMsg);

        List<Feats> featsList = userCharacterRepository.findById(id).get().getFeats();
        model.addAttribute("characterFeatName", featsList.stream()
                .map(e -> e.getFeatName())
                .collect(Collectors.joining()));
        model.addAttribute("characterFeatId", featsList.stream()
                .map(e -> e.getId()).toArray());

        ScoreIncrease abilityIncrease = scoreIncreaseRepository.findByCharacterId(id).get();
        model.addAttribute("scoreIncrease", abilityIncrease);

        return "/app/characterEditor";
    }
    @GetMapping("/character-editor-result")
    public String charEditResult(@Valid UserCharacter userCharacter,@Valid ScoreIncrease newIncrease, BindingResult result,
                                 @RequestParam long id, @RequestParam long userId){
        if (result.hasErrors())
            return "redirect:/app/character-editor-correction/"+id;

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

    //Due to approach to this problem, character is being delated as orphan of it's score increase. Should not cause...
    //...any problems and it will be changed in the future during later developement.
    @GetMapping("/character-delete-result/{id}")
    public String charDeleteResult(@PathVariable long id){
        scoreIncreaseService.deleteByUserCharacterId(id);
        return "redirect:/app/select";
    }
}
