package com.example.demo.LoanManagementApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.LoanManagementApplication.Model.Purchase;
import com.example.demo.LoanManagementApplication.Service.PurchaseService;

@RestController
@RequestMapping(value="/pur")
public class PurchaseController {
	
	@Autowired
	private PurchaseService pur_ser;
	
	@PostMapping("/purchased")
	public Purchase registerpur(@Validated @RequestBody Purchase pur) {
		Purchase n_pur = new Purchase();
		n_pur.setCategory(pur.getCategory());
		n_pur.setDescription(pur.getDescription());
		n_pur.setEmployee(pur.getEmployee());
		pur_ser.reg_purchases(n_pur);
		return n_pur;
	}
	
	@GetMapping("/app_loans")
	public List<Purchase> findmatch(@RequestParam("c_id") long x)
	{
		long cid = x;
		List<Purchase> pe = pur_ser.findall(cid);
		return pe;
	}
}
