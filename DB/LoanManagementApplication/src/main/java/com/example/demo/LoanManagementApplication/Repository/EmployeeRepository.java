package com.example.demo.LoanManagementApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.LoanManagementApplication.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	
	@Query("select password from Employee e where e.eid=:emp")
	String getpassWord(long emp);
}
