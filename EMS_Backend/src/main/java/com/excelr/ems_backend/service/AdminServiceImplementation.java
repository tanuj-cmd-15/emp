package com.excelr.ems_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.ems_backend.dtos.AdminDto;
import com.excelr.ems_backend.dtos.EmployeeRecordDTO;
import com.excelr.ems_backend.dtos.ProjectDto;
import com.excelr.ems_backend.exceptionhandling.EmployeeNotFoundException;
import com.excelr.ems_backend.helperClasses.Mappers;
import com.excelr.ems_backend.models.Admin;
import com.excelr.ems_backend.models.EmployeeRecord;
import com.excelr.ems_backend.models.ProjectDetails;
import com.excelr.ems_backend.repositories.AdminRepository;
import com.excelr.ems_backend.repositories.EmployeeRepository;

@Service
public class AdminServiceImplementation implements AdminService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private Mappers mappers;
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin createAdmin(AdminDto adminDto) {
		Admin admin = new Admin();
		admin.setName(adminDto.getName());
		admin.setCompanyMail(adminDto.getCompanyMail());
		admin.setEmploymentCode(adminDto.getEmploymentCode());
		admin.setPassword(adminDto.getPassword());
		return adminRepository.save(admin);
	}

	@Override
	public String createEmployee(EmployeeRecordDTO employeeRecordDTO) {

		EmployeeRecord employeeRecord =mappers.getEmployeeRecordEntity(employeeRecordDTO);
		if (employeeRecord.getProjects() == null || employeeRecord.getProjects().isEmpty()) {
			employeeRecord.setProjects(null);
		}
		employeeRepository.save(employeeRecord);
		return "New Employe created";
	}

	@Override
	public String deleteEmployee(Long id) {
		EmployeeRecord existRecord = findEmployeeById(id);
		employeeRepository.delete(existRecord);
		return "Employee with this id: " + id + " deleted";
	}

	@Override
	public String updateEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeRecord> getAllEmployees() {
		List<EmployeeRecord> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public EmployeeRecord findEmployeeById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with this Id: " + id));
	}

	@Override
	public String updateProjects(Long id,List<ProjectDto> projectDto) {
		EmployeeRecord employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
		employee.getProjects().clear();
		for (ProjectDto project : projectDto) {
            ProjectDetails projectDetails = mappers.getProjectEntity(project);  // Use projectMapper here
            projectDetails.setEmployee(employee);  // Set the employee reference in Project entity
            employee.getProjects().add(projectDetails);  // Add project to employee
        }
		
		employeeRepository.save(employee);
		return "Project updated to id: "+id+" successfull!.";
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

}
