package com.asem.employee_management_system.Repository;

import Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,int> {
}
