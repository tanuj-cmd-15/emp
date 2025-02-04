package com.excelr.ems_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.ems_backend.dtos.EmployeeRecordDTO;
import com.excelr.ems_backend.dtos.ProjectDto;
import com.excelr.ems_backend.models.EmployeeRecord;
import com.excelr.ems_backend.service.AdminServiceImplementation;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private AdminServiceImplementation adminService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createEmployee(@Valid @RequestBody EmployeeRecordDTO record) {
	    return new ResponseEntity<>(adminService.createEmployee(record), HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<EmployeeRecord>> getAllEmployees() {
	    return new ResponseEntity<>(adminService.getAllEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeRecord> getEmloyeeById(@PathVariable Long id){
		return new ResponseEntity<>(adminService.findEmployeeById(id),HttpStatus.OK);
	}
	
	@PutMapping("/projects/{id}")
	public ResponseEntity<String> updateProject(@PathVariable Long id,@RequestBody List<ProjectDto> projectDto) {
		return new ResponseEntity<String>(adminService.updateProjects(id, projectDto),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
		return new ResponseEntity<>(adminService.deleteEmployee(id), HttpStatus.OK);
	}
}
