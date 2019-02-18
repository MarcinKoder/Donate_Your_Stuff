package pl.mwisniewski.Donate_Your_Stuff.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/","/home"})
public class HomepageController {

    @GetMapping
    public String homePage(){
        return "index";
    }

    @GetMapping("/contact")
    public String contactPage(){return "contact";}

    @GetMapping("/about")
    public String aboutPage(){ return "about";}
}
