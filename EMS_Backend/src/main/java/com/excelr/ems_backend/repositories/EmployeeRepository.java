package com.excelr.ems_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.ems_backend.models.EmployeeRecord;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeRecord, Long> {
	
	public EmployeeRecord findByEmploymentCode(String employmentCode);

	public EmployeeRecord findByCompanyMail(String companyMail);
}
