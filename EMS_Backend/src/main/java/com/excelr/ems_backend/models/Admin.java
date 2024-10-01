package com.excelr.ems_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String EmploymentCode;
	private String companyMail;
	private String password;
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmploymentCode() {
		return EmploymentCode;
	}
	public void setEmploymentCode(String EmploymentCode) {
		this.EmploymentCode = EmploymentCode;
	}
	public String getCompanyMail() {
		return companyMail;
	}
	public void setCompanyMail(String companyMail) {
		this.companyMail = companyMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Admin() {
	}

	@Override
	public String toString() {
		return "Admin [" + "name=" + name + ", EmploymentCode=" + EmploymentCode + ", companyMail="
				+ companyMail + ", password=" + password + "]";
	}
	
	
}
