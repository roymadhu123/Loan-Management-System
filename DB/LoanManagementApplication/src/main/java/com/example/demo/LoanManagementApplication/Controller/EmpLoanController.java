package com.example.demo.LoanManagementApplication.Controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.LoanManagementApplication.Model.EmpLoan;
import com.example.demo.LoanManagementApplication.Service.EmpLoanService;



@RestController // generate & manage REST API in json format
@RequestMapping(value="/api")
public class EmpLoanController {
	@Autowired
	private EmpLoanService elservice;
	
	@PostMapping("/emploan")
	public EmpLoan registerloan(@Validated @RequestBody EmpLoan emp) {
		
		EmpLoan e1=new EmpLoan();
		// invoke service method
		
		e1.setEmployee(emp.getEmployee());
		e1.setLoan(emp.getLoan());
		Date cu_date = emp.getAp_date();
		e1.setAp_date(cu_date);
		elservice.maploan_emp(e1);
		return e1;
	}
	

	@GetMapping("/empLoan")
	public List<EmpLoan> getAllCustomers(){
		
		return elservice.getAllEmpLoan();
	}
	
	
}
