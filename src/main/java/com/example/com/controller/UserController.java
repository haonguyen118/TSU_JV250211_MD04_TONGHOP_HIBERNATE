package com.example.com.controller;

import com.example.com.model.User;
import com.example.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return  "Login";
    }

    @PostMapping("/login")
    public String login(String username, String password, RedirectAttributes redirectAttributes){
        User user = userService.login(username, password);
        if(user!=null){
            redirectAttributes.addFlashAttribute("message","Đăng nhập thành công");
            return "redirect:/home";
        }else {
            redirectAttributes.addFlashAttribute("message","Vui lòng đăng nhập trước nhé!!!");
            return   "Login";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return  "Register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model, RedirectAttributes redirectAttributes){
        if (userService.checkExistUsername(user.getUserName())) {
            model.addAttribute("user",user);
            model.addAttribute("message", "Tên đăng nhập đã tồn tại");
            return "Register";
        } else {
            boolean result = userService.save(user);
            if (result) {
                redirectAttributes.addFlashAttribute("message", "Đăng ký thành công");
                return "redirect:/login";
            } else {
                model.addAttribute("message", "Có lỗi trong quá trình đăng ký");
                return "Register";
            }
        }
    }

}
