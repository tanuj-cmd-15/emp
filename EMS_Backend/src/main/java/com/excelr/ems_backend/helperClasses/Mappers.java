package com.excelr.ems_backend.helperClasses;

import org.springframework.stereotype.Component;

import com.excelr.ems_backend.dtos.EmployeeRecordDTO;
import com.excelr.ems_backend.dtos.ProjectDto;
import com.excelr.ems_backend.models.EmployeeRecord;
import com.excelr.ems_backend.models.ProjectDetails;

@Component
public class Mappers {
	
	public static ProjectDetails getProjectEntity(ProjectDto projectDto) {
		ProjectDetails project = new ProjectDetails();
        project.setProjectCode(projectDto.getProjectCode());
        project.setStartDate(projectDto.getStartDate());
        project.setEndDate(projectDto.getEndDate());
        project.setClientName(projectDto.getClientName());
        project.setProjectName(projectDto.getProjectName());
        project.setReportingManagerEmployeeCode(projectDto.getReportingManagerEmployeeCode());
        project.setReportingManagerEmployeeMail(projectDto.getReportingManagerEmployeeMail());

        return project;
    }
	
	public EmployeeRecord getEmployeeRecordEntity(EmployeeRecordDTO dto) {
		EmployeeRecord employeeRecord = new EmployeeRecord();
		employeeRecord.setEmploymentCode(dto.getEmploymentCode());
		employeeRecord.setCompanyMail(dto.getCompanyMail());
		employeeRecord.setPassword(dto.getPassword());
		employeeRecord.setRole(dto.getRole());
		employeeRecord.setPersonalDetails(dto.getPersonalDetails());
		employeeRecord.setProfessionalDetails(dto.getProfessionalDetails());
		employeeRecord.setProjects(dto.getProjects());
		employeeRecord.setFinanceDetails(dto.getFinanceDetails());

		return employeeRecord;
	}
	
}
