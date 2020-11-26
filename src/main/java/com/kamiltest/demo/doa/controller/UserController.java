package com.kamiltest.demo.doa.controller;

import com.kamiltest.demo.doa.model.Role;
import com.kamiltest.demo.doa.model.User;
import com.kamiltest.demo.doa.viewModels.addNewUser;
import com.kamiltest.demo.manager.MyUserDetailsService;
import com.kamiltest.demo.manager.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private RoleService roleService;


    @GetMapping("/getallusers")
    public String getAllUsers(Model model)
    {
        model.addAttribute("users",this.myUserDetailsService.findAllUsers());
        return "User/getAllUsers";
    }

    @GetMapping("/adduser")
    public String addUser(Model model)
    {
        model.addAttribute("userToAdd",new User());
        model.addAttribute("roles", this.roleService.findAll());
        model.addAttribute("viewmodel",new addNewUser());
        return "User/addUser";
    }

    //this should be validated
    @PostMapping("/adduser")
    public String postMethodAddUser(Model model,
                                    @Valid @ModelAttribute("viewmodel")addNewUser addNewUser,
                                    BindingResult res)
    {
        if(res.hasErrors())
        {
            model.addAttribute("userToAdd",new User());
            model.addAttribute("roles", this.roleService.findAll());
            model.addAttribute("viewmodel",new addNewUser());
            model.addAttribute("notValidated",res.getAllErrors());
            return "User/addUser";
        }
        Optional<Role> roleToAdd = this.roleService.findById(addNewUser.getIdRole());
        if(roleToAdd.isPresent())
        {
            User user = addNewUser.getUser();
            user.getRoles().add(roleToAdd.get());
            this.myUserDetailsService.addUser(user);
        }
        return "redirect:/api/user/getallusers";
    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        this.myUserDetailsService.deleteUser(id);
        return "redirect:/api/user/getallusers";
    }
}
