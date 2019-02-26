package pl.mwisniewski.Donate_Your_Stuff.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mwisniewski.Donate_Your_Stuff.dto.UserPasswordFormDTO;
import pl.mwisniewski.Donate_Your_Stuff.model.User;
import pl.mwisniewski.Donate_Your_Stuff.repositories.UserRepository;
import pl.mwisniewski.Donate_Your_Stuff.repositories.UserRoleRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

@RequestMapping
@Controller
public class UserController {
    UserRepository userRepository;

    HttpSession httpSession;

    UserRoleRepository userRoleRepository;


    @GetMapping("/dashboard")
    public String prepareUserDashboard(Model model, Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        String name = user.getName();
        httpSession.setAttribute( "userName", name);
        model.addAttribute( "LoggedUser", user );
        return "userDashboard";
    }

    @GetMapping("/settings")
    public String prepareUserSettingsPage(Model model, Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "LoggedUser", user );
        return "userSettings";
    }


    @GetMapping("/confirmDeleteUser")
    public String confirmDeleteUserAccount(Model model, Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        model.addAttribute( "LoggedUser", user );
        return "userDelete";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(Principal principal) {
        User user = userRepository.findByEmail( principal.getName() );
        if (user != null) {
            userRepository.delete( user );
            if (httpSession != null)
                httpSession.invalidate();
            return "redirect:/login";
        }
        return "redirect:/user/settings";
    }

}

