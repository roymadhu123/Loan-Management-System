package com.example.demo.LoanManagementApplication.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="Loan")
public class Loan {
	@Id
	@Column(name="Loan_id")
	private Long lid;
	
	private String loanType;
	private int duration;
	@OneToMany(mappedBy="loan")
	private List<EmpLoan> empLoan;
	
	public Loan() {
		
	}
	public Long getLid() {
		return lid;
	}
	public void setLid(Long lid) {
		this.lid = lid;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
