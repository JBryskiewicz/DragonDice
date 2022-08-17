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
import pl.coderslab.dragondice.domain.Background;
import pl.coderslab.dragondice.domain.CurrentUser;
import pl.coderslab.dragondice.domain.User;
import pl.coderslab.dragondice.repository.BackgroundRepository;
import pl.coderslab.dragondice.service.background.BackgroundService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/background")
public class BackgroundController {
    private final BackgroundRepository backgroundRepository;
    private final BackgroundService backgroundService;

    public BackgroundController(BackgroundRepository backgroundRepository, BackgroundService backgroundService) {
        this.backgroundRepository = backgroundRepository;
        this.backgroundService = backgroundService;
    }

    @GetMapping("/list")
    public String BackgroundList(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("Background", backgroundRepository.findAll());
        return "/background/backgroundList";
    }
    @GetMapping("/background-details/{id}")
    public String BackgroundDetails(Model model, @AuthenticationPrincipal CurrentUser currentUser, @PathVariable long id){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("Background", backgroundRepository.findById(id).get());
        return "/background/backgroundDetails";
    }
    @GetMapping("/background-creator")
    public String CreateBackground(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("background", new Background());
        return "/background/backgroundCreator";
    }
    @GetMapping("/background-creator-result")
    public String CreateBackgroundResult(@Valid Background background, BindingResult result, Model model,
                                         @AuthenticationPrincipal CurrentUser currentUser){
        if(result.hasErrors()){
            User user = currentUser.getUser();
            model.addAttribute("userName", user.getUserName());
            return "/background/backgroundCreator";
        }
        backgroundService.saveBackground(background);
        return "redirect:/background/list";
    }
    @GetMapping("/background-editor/{id}")
    public String EditBackground(Model model, @PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("background", backgroundRepository.findById(id).get());
        return "background/backgroundEditor";
    }
    @GetMapping("/background-editor-result")
    public String EditBackgroundResult(@Valid Background changedBackground, BindingResult result, @RequestParam long id,
                                       Model model, @AuthenticationPrincipal CurrentUser currentUser){
        if(result.hasErrors()){
            User user = currentUser.getUser();
            model.addAttribute("userName", user.getUserName());
            return "background/backgroundEditor";
        }
        Optional<Background> existing = backgroundRepository.findById(id);
        Background background = existing.isPresent()
                ? changedBackground.cloneWithOriginalId(existing.get())
                : changedBackground;
        backgroundService.editBackground(background);
        return "redirect:/background/list";
    }
    @GetMapping("/delete/{id}")
    public String RemoveBackground(Model model, @PathVariable long id, @AuthenticationPrincipal CurrentUser currentUser){
        User user = currentUser.getUser();
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("Background", backgroundRepository.findById(id).get());
        return "background/backgroundDelete";
    }
    @GetMapping("/delete-result/{id}")
    public String RemoveBackgroundResult(@PathVariable long id){
        backgroundService.removeBackgroundById(id);
        return "redirect:/background/list";
    }
}
