package pl.coderslab.dragondice.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dragondice.domain.CurrentUser;
import pl.coderslab.dragondice.domain.User;
import pl.coderslab.dragondice.service.user.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @PostMapping("/signup-result")
    public String registerResult(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "/auth/register";
        }
        userService.saveUser(user);
        return "redirect:/auth/signin";
    }

    @GetMapping("/signin")
    public String login(){
        return "auth/login";
    }
}
