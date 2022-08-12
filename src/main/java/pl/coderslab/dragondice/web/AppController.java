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
    @GetMapping("/character-sheet/{id}")
    public String charSheet(Model model, @PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        Optional<UserCharacter> userCharacter = userCharacterRepository.findById(id);
        List<ScoreIncrease> abilityIncrease = scoreIncreaseRepository.findAllByCharacterId(id);

        model.addAttribute("userCharacter", userCharacter.get());

        model.addAttribute("strIncrease", abilityIncrease.stream().iterator().next().getStrIncreaseFour());
        model.addAttribute("dexIncrease", abilityIncrease.stream().iterator().next().getDexIncreaseFour());
        model.addAttribute("conIncrease", abilityIncrease.stream().iterator().next().getConIncreaseFour());
        model.addAttribute("intIncrease", abilityIncrease.stream().iterator().next().getIntIncreaseFour());
        model.addAttribute("wisIncrease", abilityIncrease.stream().iterator().next().getWisIncreaseFour());
        model.addAttribute("chaIncrease", abilityIncrease.stream().iterator().next().getChaIncreaseFour());

        model.addAttribute("strMod",
                ModifiersDefiner.abilityModifier(userCharacter.get().getStrAbility()
                        + userCharacter.get().getScoreIncreases().stream().iterator().next().getStrIncreaseFour()));
        model.addAttribute("dexMod",
                ModifiersDefiner.abilityModifier(userCharacter.get().getDexAbility()
                        + userCharacter.get().getScoreIncreases().stream().iterator().next().getDexIncreaseFour()));
        model.addAttribute("conMod",
                ModifiersDefiner.abilityModifier(userCharacter.get().getConAbility()
                        + userCharacter.get().getScoreIncreases().stream().iterator().next().getConIncreaseFour()));
        model.addAttribute("intMod",
                ModifiersDefiner.abilityModifier(userCharacter.get().getIntAbility()
                        + userCharacter.get().getScoreIncreases().stream().iterator().next().getIntIncreaseFour()));
        model.addAttribute("wisMod",
                ModifiersDefiner.abilityModifier(userCharacter.get().getWisAbility()
                        + userCharacter.get().getScoreIncreases().stream().iterator().next().getWisIncreaseFour()));
        model.addAttribute("chaMod",
                ModifiersDefiner.abilityModifier(userCharacter.get().getChaAbility()
                        + userCharacter.get().getScoreIncreases().stream().iterator().next().getChaIncreaseFour()));

        model.addAttribute("armorClass",
                baseTen + ModifiersDefiner.abilityModifier(userCharacter.get().getDexAbility()));

        model.addAttribute("passivePerception",
                baseTen + ModifiersDefiner.abilityModifier(userCharacter.get().getWisAbility()));
        model.addAttribute("passiveInvestigation",
                baseTen + ModifiersDefiner.abilityModifier(userCharacter.get().getIntAbility()));
        model.addAttribute("passiveInsight",
                baseTen + ModifiersDefiner.abilityModifier(userCharacter.get().getWisAbility()));

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

        Optional<User> findUser = userRepository.findById(userId);
        if (result.hasErrors()){
            return "redirect:/app/character-creator-correction";
        }
        if (userCharacter.getFeats().isEmpty()){
            userCharacter.setUser(findUser.get());
            scoreIncreaseService.saveScoreIncrease(scoreIncrease);
            List<ScoreIncrease> increase = new ArrayList<>();
            increase.add(scoreIncrease);
            userCharacter.setScoreIncreases(increase);
            userCharacterService.saveUserCharacter(userCharacter);
        }else {
            Optional<Feats> feat = featRepository.findById(Long.parseLong(feats));
            List<Feats> featsList = new ArrayList<>();
            featsList.add(feat.get());
            userCharacter.setUser(findUser.get());
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

        List<ScoreIncrease> increaseList = scoreIncreaseRepository.findAllByCharacterId(id);
        model.addAttribute("scoreIncreaseStr", increaseList.stream().iterator().next().getStrIncreaseFour());
        model.addAttribute("scoreIncreaseDex", increaseList.stream().iterator().next().getDexIncreaseFour());
        model.addAttribute("scoreIncreaseCon", increaseList.stream().iterator().next().getConIncreaseFour());
        model.addAttribute("scoreIncreaseInt", increaseList.stream().iterator().next().getIntIncreaseFour());
        model.addAttribute("scoreIncreaseWis", increaseList.stream().iterator().next().getWisIncreaseFour());
        model.addAttribute("scoreIncreaseCha", increaseList.stream().iterator().next().getChaIncreaseFour());

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

        List<ScoreIncrease> increaseList = scoreIncreaseRepository.findAllByCharacterId(id);
        model.addAttribute("scoreIncreaseStr", increaseList.stream().iterator().next().getStrIncreaseFour());
        model.addAttribute("scoreIncreaseDex", increaseList.stream().iterator().next().getDexIncreaseFour());
        model.addAttribute("scoreIncreaseCon", increaseList.stream().iterator().next().getConIncreaseFour());
        model.addAttribute("scoreIncreaseInt", increaseList.stream().iterator().next().getIntIncreaseFour());
        model.addAttribute("scoreIncreaseWis", increaseList.stream().iterator().next().getWisIncreaseFour());
        model.addAttribute("scoreIncreaseCha", increaseList.stream().iterator().next().getChaIncreaseFour());

        return "/app/characterEditor";
    }
    @GetMapping("/character-editor-result")
    public String charEditResult(@Valid UserCharacter userCharacter,@Valid ScoreIncrease scoreIncrease, BindingResult result,
                                 @RequestParam long id, @RequestParam long userId){

        Optional<User> findingUser = userRepository.findById(userId);

        if (result.hasErrors()){
            return "redirect:/app/character-editor-correction/"+id;
        }else {
            userCharacter.setUser(findingUser.get());
            List<ScoreIncrease> increase = new ArrayList<>();
            increase.add(scoreIncrease);
            userCharacter.setScoreIncreases(increase);
            scoreIncreaseService.editScoreIncrease(scoreIncrease);
            userCharacterService.editUserCharacter(userCharacter);
            return "redirect:/app/select";
        }
    }
    @GetMapping("/character-delete/{id}")
    public String charDelete(Model model, @PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("userCharacter", userCharacterRepository.findById(id).get());
        return "/app/characterDelete";
    }

    @GetMapping("/character-delete-result/{id}")
    public String charDeleteResult(@PathVariable long id){
        userCharacterRepository.deleteById(id);
        return "redirect:/app/select";
    }
}
