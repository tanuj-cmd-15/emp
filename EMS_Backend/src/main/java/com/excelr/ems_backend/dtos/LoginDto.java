package com.excelr.ems_backend.dtos;

public class LoginDto {
	private String mailOrEmpCode;
	private String password;

	public String getMailOrEmpCode() {
		return mailOrEmpCode;
	}

	public void setMailOrEmpCode(String mailOrEmpCode) {
		this.mailOrEmpCode = mailOrEmpCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDto [mailOrEmpCode=" + mailOrEmpCode + ", password=" + password + "]";
	}

	public LoginDto() {
		super();
	}

}
