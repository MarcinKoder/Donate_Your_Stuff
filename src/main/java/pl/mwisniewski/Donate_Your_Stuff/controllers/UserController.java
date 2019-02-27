package pl.mwisniewski.Donate_Your_Stuff.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.mwisniewski.Donate_Your_Stuff.core.UserService;
import pl.mwisniewski.Donate_Your_Stuff.dto.UserPasswordFormDTO;
import pl.mwisniewski.Donate_Your_Stuff.model.Donate;
import pl.mwisniewski.Donate_Your_Stuff.model.User;
import pl.mwisniewski.Donate_Your_Stuff.repositories.DonateRepository;
import pl.mwisniewski.Donate_Your_Stuff.repositories.UserRepository;
import pl.mwisniewski.Donate_Your_Stuff.repositories.UserRoleRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpSession httpSession;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    DonateRepository donateRepository;
    @Autowired
    UserService userService;

    @GetMapping("/dashboard")
    public String prepareUserDashboard(Model model, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        System.out.println(principal.getName());
        String name = user.getName();
        httpSession.setAttribute("userName", name);
        model.addAttribute("LoggedUser", user);
        return "userDashboard";
    }

    @GetMapping("/settings")
    public String prepareUserSettingsPage(Model model, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("LoggedUser", user);
        return "userSettings";
    }

    @GetMapping("/confirmDelete")
    public String confirmDeleteUserAccount(Model model, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("LoggedUser", user);
        return "userDelete";
    }

    @GetMapping("/delete")
    public String deleteUser(Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        if (user != null) {
            userRepository.delete(user);
            if (httpSession != null)
                httpSession.invalidate();
            return "redirect:/login";
        }
        return "redirect:/user/settings";
    }

    @GetMapping("/changePassword")
    public String confirmChangePassword(Model model, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("LoggedUser", user);
        model.addAttribute( "userToEdit", userService.userToEditPassword(user.getId()));
        return "userChangePassword";
    }

    @PostMapping("/changePassword")
    public String changePassword(@ModelAttribute("userToEdit") @Valid UserPasswordFormDTO changeUserPasswordForm, Principal principal, Model model, BindingResult result) {
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("LoggedUser", user);
        model.addAttribute( "userToEdit", userService.userToEditPassword(user.getId()));
        if (result.hasErrors()) {
            return "/user/settings";
        }
        boolean success = userService.changeUserPassword(changeUserPasswordForm);
        if (success) {
            return "redirect:/user/dashboard";
        } else {
            result.rejectValue( "confirmedPassword", null, "Podane hasła nie są tożsame!" );
            return "userChangePassword";
        }
    }


    @GetMapping("/edit")
    public String prepareUserToEdit(Model model, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("user", user);
        return "userEditForm";
    }

    @PostMapping("/edit")
    public String editUser(@Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            return "userEditForm";
        }
        if (user.getId() != null) {
            userRepository.save(user);
        }
        return "redirect:/user/settings";
    }

    @GetMapping("/donates")
    public String listOfUserOrders(Model model, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        List<Donate> userDonates = donateRepository.findAllByUser(user);
        model.addAttribute("userDonates", userDonates);
        return "userDonates";
    }

    @GetMapping("/donates/archive/{id:[1-9][0-9]*")
    public String archiveDonate(@PathVariable Long id) {
        Donate donate = donateRepository.findById(id).get();
        if (donate.getId() == null) {
            return "Nie znaleziono takiej donacji";
        }
        if (donate.getId() != null) {
            donate.setStatus(true);
        }
        return "redirect:/user/donates";
    }
}

