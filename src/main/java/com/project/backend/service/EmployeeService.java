package com.project.backend.service;

import java.util.List;

import com.project.backend.model.Employee;

public interface EmployeeService {
    
    Employee postEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee getEmployee(Integer id);

    Employee putEmployee(Integer id, Employee employee);

    String deleteEmployee(Integer id);

}
