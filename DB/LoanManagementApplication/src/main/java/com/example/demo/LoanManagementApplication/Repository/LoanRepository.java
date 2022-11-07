package com.example.demo.LoanManagementApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.LoanManagementApplication.Model.Loan;

public interface LoanRepository extends JpaRepository<Loan,Long>{

}
