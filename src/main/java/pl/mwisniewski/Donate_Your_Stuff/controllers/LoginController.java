package pl.mwisniewski.Donate_Your_Stuff.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mwisniewski.Donate_Your_Stuff.dto.UserDto;

@RequestMapping
@Controller
public class LoginController {
    @GetMapping("/login")
    public String prepareLoginForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "login";
    }
}
