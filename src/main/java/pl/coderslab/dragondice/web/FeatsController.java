package pl.coderslab.dragondice.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.dragondice.domain.CurrentUser;
import pl.coderslab.dragondice.domain.Feats;
import pl.coderslab.dragondice.domain.User;
import pl.coderslab.dragondice.repository.FeatRepository;
import pl.coderslab.dragondice.service.feats.FeatService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/feats")
public class FeatsController {
    private final FeatRepository featRepository;
    private final FeatService featService;

    public FeatsController(FeatRepository featRepository, FeatService featService) {
        this.featRepository = featRepository;
        this.featService = featService;
    }
    @GetMapping("/list")
    public String FeatList(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("Feats", featRepository.findAll());
        return "/feats/featsList";
    }
    @GetMapping("/feat-details/{id}")
    public String FeatDetails(Model model, @AuthenticationPrincipal CurrentUser currentUser, @PathVariable long id){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("Feat", featRepository.findById(id).get());
        return "/feats/featDetails";
    }
    @GetMapping("/feat-creator")
    public String CreateFeat(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("feat", new Feats());
        return "/feats/featCreator";
    }
    @GetMapping("/feat-creator-result")
    public String CreateFeatResult(@Valid Feats feats, BindingResult result){
        if(result.hasErrors()){
            return "redirect:/feats/feat-creator/";
        }
        featService.saveFeat(feats);
        return "redirect:/feats/list";
    }
    @GetMapping("/feat-editor/{id}")
    public String EditFeat(Model model, @PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("Feat", featRepository.findById(id).get());
        return "feats/featEditor";
    }
    @GetMapping("/feat-editor-result")
    public String EditFeatResult(@Valid Feats changedFeat, BindingResult result, @RequestParam long id){
        if(result.hasErrors()){
            return "redirect:/feats/feat-editor/";
        }
        Optional<Feats> existing = featRepository.findById(id);
        Feats feats = existing.isPresent()
                ? changedFeat.cloneWithOriginalId(existing.get())
                : changedFeat;
        featService.editFeat(feats);
        return "redirect:/feats/list";
    }
    @GetMapping("/delete/{id}")
    public String RemoveFeat(Model model, @PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("Feat", featRepository.findById(id).get());
        return "feats/featDelete";
    }
    @GetMapping("/delete-result/{id}")
    public String RemoveRaceResult(@PathVariable long id){
        featService.removeFeat(id);
        return "redirect:/feats/list";
    }
}
