package com.project.backend.service.impl;

import java.util.List;
import java.util.Optional;

import com.project.backend.dao.EmployeeDao;
import com.project.backend.model.Employee;
import com.project.backend.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {

        this.employeeDao = employeeDao;
    }

    @Override
    public Employee postEmployee(Employee employee) {

        return employeeDao.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {

        return employeeDao.findAll();
    }

    @Override
    public Employee getEmployee(Integer id) {
        return employeeDao.findById(id).get();
    }

    @Override
    public Employee putEmployee(Integer id, Employee employee) {
        
        Employee emp = getEmployee(id);

        emp.setCode(employee.getCode());
        emp.setName(employee.getName());
        emp.setGender(employee.getGender());
        emp.setMobile(employee.getMobile());
        emp.setDob(employee.getDob());

        return employeeDao.save(emp);

    }

    @Override
    public String deleteEmployee(Integer id) {
        
        Optional<Employee> emp = employeeDao.findById(id);

        if(emp.isPresent()){
            employeeDao.deleteById(id);
            return "Employee Deleted";
        }
        else{
            return "Employee not found";
        }

    }
    
}