package com.example.demo.LoanManagementApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.LoanManagementApplication.Model.EmpLoan;



public interface EmpLoanRepository extends JpaRepository<EmpLoan,Long>{

}
