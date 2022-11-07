package com.example.demo.LoanManagementApplication.Controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.LoanManagementApplication.Model.Employee;
import com.example.demo.LoanManagementApplication.Service.EmployeeService;

@RestController
@RequestMapping(value="/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService EmpSer;
	
	//open postman and make Post requet - http://localhost:8080/test/api/register
	//under body tab -->raw -->text -->json and type the json data to be saved
	@PostMapping("/register")
	@CrossOrigin(origins="http://localhost:8086/")
	public Employee CreateEmp(@Validated @RequestBody Employee Emp) {
		Employee e1 = new Employee();
		e1.setDepartment(Emp.getDepartment());
		e1.setDesignition(Emp.getDesignition());
		e1.setName(Emp.getName());
		e1.setPassword(Emp.getPassword());
		EmpSer.registerCustomer(Emp);
		return e1;
		
	}
	@GetMapping("/onpass")
	@CrossOrigin(origins="http://localhost:3000/")
	public String password(@PathVariable long emp) {
		return EmpSer.getpassword(emp);
	}
    @PostMapping("/Employees")
    @CrossOrigin(origins="http://localhost:3000/")
	public List<Employee> getAllEmployees(){
		return EmpSer.getAllCustomers();
	}
    
    @GetMapping("/verify")
    @CrossOrigin(origins="http://localhost:3000/")
	public int Verify(@Validated @RequestBody Map<String,Object> credentials) {
    	Long Emp_id = (Long) credentials.get("Employee_id");
    	String password = (String) credentials.get("Password");
    	List<Employee> li = EmpSer.getAllCustomers();
    	int req = -1;
    	for(Employee ep:li) {
    		if(ep.getEid().compareTo(Emp_id)>0) {
    			req = 0;
    			if(ep.getPassword().compareTo(password)>0)
    				req = 1;
    			break;
    		}
    			
    	}
    	return req;
	}
}
