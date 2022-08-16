package pl.coderslab.dragondice.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dragondice.domain.CurrentUser;
import pl.coderslab.dragondice.domain.Race;
import pl.coderslab.dragondice.domain.User;
import pl.coderslab.dragondice.repository.RaceRepository;
import pl.coderslab.dragondice.service.race.RaceService;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@Validated
@RequestMapping("/race")
public class RaceController {
    private final RaceRepository raceRepository;
    private final RaceService raceService;

    public RaceController(RaceRepository raceRepository, RaceService raceService) {
        this.raceRepository = raceRepository;
        this.raceService = raceService;
    }
    @GetMapping("/list")
    public String RaceList(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("Races", raceRepository.findAll());
        return "/race/raceList";
    }
    @GetMapping("/race-details/{id}")
    public String RaceDetails(Model model, @AuthenticationPrincipal CurrentUser currentUser, @PathVariable long id){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("Race", raceRepository.findById(id).get());
        return "/race/raceDetails";
    }
    @GetMapping("/race-creator")
    public String CreateRace(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("race", new Race());
        return "/race/raceCreator";
    }
    @GetMapping("/race-creator-result")
    public String CreateRaceResult(@Valid Race race, BindingResult result){
        if(result.hasErrors()){
            return "redirect:/race/race-creator/";
        }
        raceService.saveRace(race);
        return "redirect:/race/list";
    }
    @GetMapping("/race-editor/{id}")
    public String EditRace(Model model, @PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("Race", raceRepository.findById(id).get());
        return "race/raceEditor";
    }
    @GetMapping("/race-editor-result")
    public String EditRaceResult(@Valid Race changedRace, BindingResult result, @RequestParam long id){
        if(result.hasErrors()){
            return "redirect:/race/race-creator/";
        }
        Optional<Race> checkrace = raceRepository.findById(id);
        System.out.println(checkrace.get().getId());

        Optional<Race> existing = raceRepository.findById(id);
        Race race = existing.isPresent()
                ? changedRace.cloneWithOriginalId(existing.get())
                : changedRace;

        raceService.editRace(race);
        return "redirect:/race/list";
    }
    @GetMapping("/delete/{id}")
    public String RemoveRace(Model model, @PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("Race", raceRepository.findById(id).get());
        return "race/raceDelete";
    }
    @GetMapping("/delete-result/{id}")
    public String RemoveRaceResult(@PathVariable long id){
        raceService.removeRace(id);
        return "redirect:/race/list";
    }
}
