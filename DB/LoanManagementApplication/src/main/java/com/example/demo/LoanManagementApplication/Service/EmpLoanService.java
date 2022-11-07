package com.example.demo.LoanManagementApplication.Service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.LoanManagementApplication.Model.EmpLoan;
import com.example.demo.LoanManagementApplication.Repository.EmpLoanRepository;

@Service
@Transactional
public class EmpLoanService {
	@Autowired
	private EmpLoanRepository elrepo;
	
	public void maploan_emp(EmpLoan emp) {
		elrepo.save(emp); // invoke jpa repository save() method
	}
	
	public List<EmpLoan> getAllEmpLoan()
	{
		return elrepo.findAll();
	}
}
