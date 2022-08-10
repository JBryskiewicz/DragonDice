package pl.coderslab.dragondice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dragondice.domain.Feats;
import pl.coderslab.dragondice.domain.UserCharacter;
import pl.coderslab.dragondice.mechanics.ModifiersDefiner;
import pl.coderslab.dragondice.repository.BackgroundRepository;
import pl.coderslab.dragondice.repository.FeatRepository;
import pl.coderslab.dragondice.repository.RaceRepository;
import pl.coderslab.dragondice.repository.UserCharacterRepository;
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

    private final int baseTen = 10;
    private final String CharacterDataErrorMsg = "Please, fill your character's data properly :)";

    public AppController(UserCharacterRepository userCharacterRepository,
                         RaceRepository raceRepository, FeatRepository featRepository,
                         BackgroundRepository backgroundRepository, UserCharacterService userCharacterService) {

        this.userCharacterRepository = userCharacterRepository;
        this.raceRepository = raceRepository;
        this.featRepository = featRepository;
        this.backgroundRepository = backgroundRepository;
        this.userCharacterService = userCharacterService;
    }

    //TODO Remember to remake this method once there's session for findAll to include user ID, so it shows only
    // Specific user's characters!!!
    @GetMapping("/select")
    public String charSelect(Model model){
        model.addAttribute("userCharacter", userCharacterRepository.findAll());
        return "/app/characterSelect";
    }

    @GetMapping("/character-sheet/{id}")
    public String charSheet(Model model, @PathVariable long id){
        Optional<UserCharacter> userCharacter = userCharacterRepository.findById(id);

        model.addAttribute("userCharacter", userCharacter.get());

        model.addAttribute("strMod",
                ModifiersDefiner.abilityModifier(userCharacter.get().getStrAbility()));
        model.addAttribute("dexMod",
                ModifiersDefiner.abilityModifier(userCharacter.get().getDexAbility()));
        model.addAttribute("conMod",
                ModifiersDefiner.abilityModifier(userCharacter.get().getConAbility()));
        model.addAttribute("intMod",
                ModifiersDefiner.abilityModifier(userCharacter.get().getIntAbility()));
        model.addAttribute("wisMod",
                ModifiersDefiner.abilityModifier(userCharacter.get().getWisAbility()));
        model.addAttribute("chaMod",
                ModifiersDefiner.abilityModifier(userCharacter.get().getChaAbility()));

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
    public String charCreator(Model model){
        model.addAttribute("Race", raceRepository.findAll());
        model.addAttribute("Feats", featRepository.findAll());
        model.addAttribute("Background", backgroundRepository.findAll());
        model.addAttribute("userCharacter", new UserCharacter());
        return "/app/characterCreator";
    }

    @GetMapping("/character-creator-correction")
    public String charCreatorWithError(Model model){
        model.addAttribute("Race", raceRepository.findAll());
        model.addAttribute("Feats", featRepository.findAll());
        model.addAttribute("Background", backgroundRepository.findAll());
        model.addAttribute("userCharacter", new UserCharacter());
        model.addAttribute("errorMsg", CharacterDataErrorMsg);
        return "/app/characterCreator";
    }

    @GetMapping("/character-creator-result")
    public String charCreatorResult(@Valid UserCharacter userCharacter, BindingResult result, @RequestParam String feats){
        if (result.hasErrors()){
            return "redirect:/app/character-creator-correction";
        }
        if (userCharacter.getFeats().isEmpty()){
            userCharacter.setFeats(null);
            userCharacterService.saveUserCharacter(userCharacter);
        }else {
            Optional<Feats> feat = featRepository.findById(Long.parseLong(feats));
            List<Feats> featsList = new ArrayList<>();
            featsList.add(feat.get());
            userCharacterService.saveUserCharacter(userCharacter);
        }
        return "redirect:/app/select";
    }

    @GetMapping("/character-editor/{id}")
    public String charEdit(Model model, @PathVariable long id){
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

        return "/app/characterEditor";
    }

    @GetMapping("/character-editor-correction/{id}")
    public String charEditWithError(Model model, @PathVariable long id){
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

        return "/app/characterEditor";
    }

    @GetMapping("/character-editor-result")
    public String charEditResult(UserCharacter userCharacter, BindingResult result, @RequestParam long id){
        if (result.hasErrors()){
            return "redirect:/app/character-editor-correction/"+id;
        }
        userCharacterService.editUserCharacter(userCharacter);
        return "redirect:/app/select";
    }

    @GetMapping("/character-delete/{id}")
    public String charDelete(Model model, @PathVariable long id){
        model.addAttribute("userCharacter", userCharacterRepository.findById(id).get());
        return "/app/characterDelete";
    }
    @GetMapping("/character-delete-result/{id}")
    public String charDeleteResult(@PathVariable long id){
        userCharacterRepository.deleteById(id);
        return "redirect:/app/select";
    }

    //TODO Fetch JavaScript for "dice rolling".
}
