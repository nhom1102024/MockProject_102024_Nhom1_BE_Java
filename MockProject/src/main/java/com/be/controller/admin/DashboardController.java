package com.be.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class DashboardController {

    @GetMapping("/admin")
    public String getDashBoardPage(Model model) {
        return "admin/dashboard/show";
    }

}