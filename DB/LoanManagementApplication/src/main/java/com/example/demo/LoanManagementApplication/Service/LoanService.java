package com.example.demo.LoanManagementApplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.LoanManagementApplication.Model.Loan;
import com.example.demo.LoanManagementApplication.Repository.LoanRepository;

@Service
@Transactional

public class LoanService {
	@Autowired
	private LoanRepository lrepo;
	
	public void registerloantype(Loan loan) {
		 lrepo.save(loan); // invoke jpa repository save() method
	}
	
	public List<Loan> getAllLoan()
	{
		return lrepo.findAll();
	}
}
