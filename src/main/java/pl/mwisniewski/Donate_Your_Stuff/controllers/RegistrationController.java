package pl.mwisniewski.Donate_Your_Stuff.controllers;

import org.springframework.stereotype.Controller;;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.mwisniewski.Donate_Your_Stuff.core.RegistrationService;
import pl.mwisniewski.Donate_Your_Stuff.dto.RegistrationFormDTO;

import javax.validation.Valid;

@Controller
@RequestMapping
public class RegistrationController {


    private RegistrationService registrationService;


    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public String prepareRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationFormDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid RegistrationFormDTO registrationFormDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        boolean success = registrationService.register(registrationFormDTO);
        if (success) {
            return "redirect:/login";
        } else {
            result.rejectValue("email", null, "Email jest już w systemie");
            return "register";
        }
    }
}