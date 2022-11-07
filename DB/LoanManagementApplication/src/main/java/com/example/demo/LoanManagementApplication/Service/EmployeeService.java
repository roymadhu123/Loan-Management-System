package com.example.demo.LoanManagementApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.LoanManagementApplication.Model.Employee;
import com.example.demo.LoanManagementApplication.Repository.EmployeeRepository;

@Service
@Transactional

public class EmployeeService {
	@Autowired
	private EmployeeRepository erepo;
	
	public void registerCustomer(Employee emp) {
		erepo.save(emp); // invoke jpa repository save() method
	}
	
	public List<Employee> getAllCustomers()
	{
		return erepo.findAll();
	}
	public String getpassword(long emp) {
		// TODO Auto-generated method stub
		return erepo.getpassWord(emp);
	}

	@SuppressWarnings("deprecation")
	public Employee getuserById(long user) {
		// TODO Auto-generated method stub
		return erepo.getById(user);
	}

	public boolean presence(long user) {
		// TODO Auto-generated method stub
		
		return erepo.existsById(user);
	}
}
