package pl.coderslab.dragondice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dragondice.domain.User;

@Controller
@RequestMapping("/register")
public class UserController {

    @GetMapping("/signup")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "/register";
    }

}
