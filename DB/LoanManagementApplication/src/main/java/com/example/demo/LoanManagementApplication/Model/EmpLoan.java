package com.example.demo.LoanManagementApplication.Model;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class EmpLoan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Myloan_id")
	int loan_id;
	
	
	@ManyToOne
	@JoinColumn(name="employee_id", referencedColumnName="Employee_id")
	@JsonBackReference
	public Employee employee;
	

	@ManyToOne
	@JoinColumn(name="loan_id", referencedColumnName="Loan_id")
	@JsonBackReference
	public Loan loan;
	
	public EmpLoan() {
		
	}
	
	public Loan getLoan() {
		return loan;
	}
	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Column(name="Approved_date")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date ap_date;
	
	
	
	public Date getAp_date() {
		return ap_date;
	}
	public void setAp_date(Date ap_date) {
		this.ap_date = ap_date;
	}
	
	
	
	
}
