package com.example.demo.LoanManagementApplication.Model;
import java.util.Base64;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Employee_id")
	private Long eid;
	@Column(name = "Employee_name")
	private String name;
	private String password;
	private String Designition;
	private String Department;
	//No-Argument Constructor
	@OneToMany(mappedBy="employee")
	private List<Purchase> purchases;

	@OneToMany(mappedBy="employee")
	private List<EmpLoan> EmpLoan;
	public Employee() {
		}

	public Long getEid() {
		return eid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		byte[] decodeBytes = Base64.getDecoder().decode(this.password);
		String decodedString = new String(decodeBytes);
		return decodedString;
	}

	public void setPassword(String password) {
		Base64.Encoder encoder = Base64.getEncoder();
		String normalString = password;
		String encodedString = encoder.encodeToString(normalString.getBytes());
		this.password = encodedString;
	}

	public String getDesignition() {
		return Designition;
	}

	public void setDesignition(String designition) {
		Designition = designition;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}
	
	}
