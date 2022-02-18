package com.azurealstn.blogproject.controller;

import com.azurealstn.blogproject.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/auth/user/save")
    public String userSave() {
        return "layout/user/user-save";
    }

    @GetMapping("/auth/user/login")
    public String userLogin() {
        return "layout/user/user-login";
    }

    @GetMapping("/user/update")
    public String userUpdate(@AuthenticationPrincipal PrincipalDetail principalDetail, Model model) {
        model.addAttribute("principal", principalDetail.getUser());
        return "layout/user/user-update";
    }
}
