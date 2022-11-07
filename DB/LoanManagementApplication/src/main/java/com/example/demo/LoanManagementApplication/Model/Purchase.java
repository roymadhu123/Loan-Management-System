package com.example.demo.LoanManagementApplication.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long issue_id;
	@ManyToOne
	@JoinColumn(name="employee_id", referencedColumnName="Employee_id")
	@JsonBackReference
	private Employee employee;
	
	private String description;
	private String item_make;
	private String category;
	private int valuation;
	
	
	public Purchase() {
		
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Long getIssue_id() {
		return issue_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getItem_make() {
		return item_make;
	}
	public void setItem_make(String item_make) {
		this.item_make = item_make;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getValuation() {
		return valuation;
	}
	public void setValuation(int valuation) {
		this.valuation = valuation;
	}
	
}
