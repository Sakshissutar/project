package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;


@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    
    @GetMapping("hello")
    String hello(){
        return "hello world";
    }

    @PostMapping("save")
    Employee addEmployee(@RequestBody() Employee emp){
        return employeeService.save(emp);
    }

    @GetMapping("all")
    List<Employee> getAll(){
        return employeeService.findAll();
    }

    @RequestMapping("/find/{id}")
    private Employee getEmployee(@PathVariable(name="id")int employeeid)
    {
        return employeeService.getEmployeeById(employeeid);
    }
    @PutMapping("/edit/{id}")
    private Employee updateEmployee(@RequestBody Employee employee,@PathVariable int id){
        employee.setId(id);
        employeeService.save(employee);
        return employee;
    }
    
    @DeleteMapping("/delete/{id}")
    private void cancelEmployee(@PathVariable("id") int id){
        employeeService.deleteById(id);
    }
} 
