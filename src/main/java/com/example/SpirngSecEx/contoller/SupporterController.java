package com.example.SpirngSecEx.contoller;


import com.example.SpirngSecEx.model.Supporter;
import com.example.SpirngSecEx.service.SupporterService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/supporter")
public class SupporterController {

    private SupporterService supporterService;

    public SupporterController(SupporterService supporterService) {
        this.supporterService = supporterService;
    }

    @GetMapping("")
    public String supporterMenu(){
        return "supporter/menu";
    }

    @GetMapping("/available")
    public String showSupporters(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authentication.getName());
        model.addAttribute("supporters", supporterService.getSupporters());
        return "supporter/supporter";
    }

    @GetMapping("/details/{id}")
    public String supporterDetails (@PathVariable Integer id, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authentication.getName());
        Supporter sup = supporterService.getSupporter(id);
        model.addAttribute("supporter", sup);
        return "supporter/supporter_details";
    }


}
