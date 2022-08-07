package pl.coderslab.dragondice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import pl.coderslab.dragondice.domain.UserCharacter;
import pl.coderslab.dragondice.repository.BackgroundRepository;
import pl.coderslab.dragondice.repository.FeatRepository;
import pl.coderslab.dragondice.repository.RaceRepository;
import pl.coderslab.dragondice.repository.UserCharacterRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/app")
public class AppController {

    private final UserCharacterRepository userCharacterRepository;
    private final RaceRepository raceRepository;
    private final FeatRepository featRepository;
    private final BackgroundRepository backgroundRepository;

    public AppController(UserCharacterRepository userCharacterRepository,
                         RaceRepository raceRepository, FeatRepository featRepository,
                         BackgroundRepository backgroundRepository) {

        this.userCharacterRepository = userCharacterRepository;
        this.raceRepository = raceRepository;
        this.featRepository = featRepository;
        this.backgroundRepository = backgroundRepository;
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
        System.out.println(userCharacter);
        return "/app/characterSheet";
    }

    @GetMapping("/character-creator")
    public String charCreator(Model model){
        System.out.println("Hello");
        model.addAttribute("Race", raceRepository.findAll());
        model.addAttribute("Feats", featRepository.findAll());
        model.addAttribute("Background", backgroundRepository.findAll());
        model.addAttribute("userCharacter", new UserCharacter());
        return "/app/characterCreator";
    }


    @PostMapping("/character-creator-result")
    public String charCreatorResult(UserCharacter userCharacter){
        userCharacterRepository.save(userCharacter);
        return "redirect:/app/select";
    }
}
