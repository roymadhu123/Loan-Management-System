package com.example.demo.LoanManagementApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.LoanManagementApplication.Model.Loan;
import com.example.demo.LoanManagementApplication.Service.LoanService;

@RestController
@RequestMapping(value="/loan")
public class LoanController {
	@Autowired
	private LoanService loanser;
	
	@PostMapping(value="/loan_ty")
	public Loan newloan(@Validated @RequestBody Loan loan1) {
		Loan n_loan = new Loan();
		n_loan.setDuration(loan1.getDuration());
		n_loan.setLid(loan1.getLid());
		n_loan.setLoanType(loan1.getLoanType());
		loanser.registerloantype(n_loan);
		return n_loan;
		
	}
}
