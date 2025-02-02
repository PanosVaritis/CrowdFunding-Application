package com.example.SpirngSecEx.contoller;

import com.example.SpirngSecEx.model.Project;
import com.example.SpirngSecEx.model.Users;
import com.example.SpirngSecEx.service.MyUserDetailsService;
import com.example.SpirngSecEx.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private ProjectService projectService;

    public AdminController(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }


    @GetMapping("")
    public String adminMenu(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authentication.getName());
        return "admin/menu";
    }


    @GetMapping("/users")
    public String showUsers(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authentication.getName());
        List<Users> users = myUserDetailsService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/usersPage";
    }

    @PostMapping("users/{id}/enable")
    public String enableUser(@PathVariable int id, boolean enabled, Model model) {
        Optional<Users> optionalUser = Optional.ofNullable(myUserDetailsService.findUser(id));
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            user.setEnabled(enabled);
            myUserDetailsService.saveUser(user);
            model.addAttribute("success", "User status updated successfully.");
        } else {
            model.addAttribute("error", "User not found.");
        }
        return "admin/usersPage"; // Επιστρέφει το template "usersPage.html"
    }


    @GetMapping("/project")
    public String showProject(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", authentication.getName());
        model.addAttribute("username", authentication.getName());
        List<Project> projects = projectService.getProjects();
        model.addAttribute("projects", projects);
        return "admin/project_admin";
    }

    @PostMapping("project/{id}/status")
    public String updateProject(@PathVariable int id, boolean status, Model model) {
        Optional<Project> optionalProject = Optional.ofNullable(projectService.getProject(id));
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.setStatus(status);
            projectService.saveProject(project);
            model.addAttribute("success", "User status updated successfully.");
        } else {
            model.addAttribute("error", "User not found.");
        }
        return "admin/project_admin";
    }
}
