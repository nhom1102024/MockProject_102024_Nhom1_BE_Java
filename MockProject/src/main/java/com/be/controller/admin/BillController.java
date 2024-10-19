package com.be.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BillController {
    @RequestMapping(value = "/admin/bills", method = RequestMethod.GET)
    public String getBillsPage() {
        return "admin/bill/show";
    }
}
