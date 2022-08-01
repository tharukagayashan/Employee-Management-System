package com.project.backend.rest;

import java.util.List;

import com.project.backend.model.Employee;
import com.project.backend.service.EmployeeService;
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

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployees(){
        List<Employee> emp = employeeService.getEmployees();
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Integer id){
        Employee emp = employeeService.getEmployee(id);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.postEmployee(employee);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee){
        Employee emp = employeeService.putEmployee(id, employee);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer id){
        String output = employeeService.deleteEmployee(id);
        return new ResponseEntity<>(output,HttpStatus.OK);
    }
    
}
