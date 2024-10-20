package com.be.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.be.model.Bill;
import com.be.model.Customer;
import com.be.model.Service;
import com.be.service.BillService;

@Controller
public class BillController {

    private final BillService billService;

    
    public BillController(BillService billService) {
        this.billService = billService;
    }


    @RequestMapping(value = "/admin/bill", method = RequestMethod.GET)
    public String getBillsPage(Model model) {
        List<Bill> bills = this.billService.getAllBills();
        model.addAttribute("bills", bills);
        return "admin/bill/show";
    }

     @GetMapping("/admin/bill/delete/{id}")
    public String getOrderDeletePage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("newBill", new Bill());
        return "admin/bill/delete";
    }

    @PostMapping("/admin/bill/delete")
    public String postDeleteOrder(Model model, @ModelAttribute("newBill") Bill bill) {
        this.billService.deleteABill(bill.getBill_id());
        return "redirect:/admin/bill";
    }

    @RequestMapping("/admin/bill/update/{id}")
    public String getUpdatePage(Model model, @PathVariable int id) {
        Optional<Bill> optionalBill = this.billService.getABill(id);
        Bill currentBill = optionalBill.get(); 
        model.addAttribute("newBill", currentBill);
        
        return "admin/bill/update";
    }

    @PostMapping("/admin/bill/update")
    public String postUpdateOrder(Model model, @ModelAttribute("newBill") Bill bill) {
        Optional<Bill> billOptional = this.billService.getABill(bill.getBill_id());
        if (billOptional.isPresent()) {
            Bill currentBill = billOptional.get();
            Customer customer = this.billService.getACustomer(bill.getCustomer().getCustomer_id()).get();
            Service service = this.billService.getAService(bill.getService().getService_id()).get();
            currentBill.setCustomer(customer);
            currentBill.setService(service);
            currentBill.setAmount(bill.getAmount());
            currentBill.setDueDateTime(bill.getDueDateTime());
            currentBill.setCreatedDateTime(bill.getCreatedDateTime());
            currentBill.setLateFee(bill.getLateFee());
            currentBill.setStatus(bill.getStatus());
            this.billService.handleSaveBill(bill);
        }
        return "redirect:/admin/bill";
    }

    @GetMapping("/admin/bill/create")
    public String getCreatePage(Model model) {
        model.addAttribute("newBill", new Bill());
        model.addAttribute("customers", this.billService.getAllCustomers());
        model.addAttribute("services", this.billService.getAllServices());
        return "admin/bill/create";
    }

    @PostMapping("/admin/bill/create")
    public String postCreatePage(Model model, @ModelAttribute("newBill") Bill bill) {
        if(bill !=null) {
            bill.setCustomer(this.billService.getCustomerByName(bill.getCustomer().getFullName()));
            bill.setService(this.billService.getServiceByName(bill.getService().getNameService()));
        }
        this.billService.handleSaveBill(bill);
        return "redirect:/admin/bill";
    }
}
