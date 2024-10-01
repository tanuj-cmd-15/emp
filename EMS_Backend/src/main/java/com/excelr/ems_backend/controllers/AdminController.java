package com.excelr.ems_backend.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.ems_backend.dtos.AdminDto;
import com.excelr.ems_backend.models.Admin;
import com.excelr.ems_backend.service.AdminServiceImplementation;


@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private AdminServiceImplementation adminService;
	
	@GetMapping("/test")
	public String testAdmin() {
		model.addAttribute("message","Admin controller is working");
		return "Admmin/test";
	}

	@GetMapping("/new")
	public String showAddAdminForm(Model model) {
		model.addAttribute("adminDto", new AdminDto());
		return "Admin/addemply"; // Thymeleaf template for adding admin
	}

	@PostMapping("/new")
	public String addNewAdmin(@Valid @ModelAttribute("adminDto") AdminDto adminDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "Admin/addemply"; // Return to form if validation errors
		}
		adminService.createAdmin(adminDto);
		return "redirect:/admin/list"; // Redirect to admin list after successful addition
	}


	@GetMapping("/list")
	public String getAllAdmins(Model model) {
		List<Admin> admins = adminService.getAllAdmins();
		model.addAttribute("admins", admins);
		return "Admin/totalemply"; // Thymeleaf template to display admins
	}

	@GetMapping("/update/{id}")
	public String showUpdateAdminForm(@PathVariable Long id, Model model) {
		Admin admin = adminService.getAdminById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found with id " + id));
		model.addAttribute("admin", admin);
		return "Admin/updatepage"; // Thymeleaf template for updating admin
	}

	@PostMapping("/update")
	public String updateAdmin(@Valid @ModelAttribute("admin") Admin admin, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "Admin/updatepage";
		}
		adminService.updateAdmin(admin);
		return "redirect:/admin/list";
	}


}
