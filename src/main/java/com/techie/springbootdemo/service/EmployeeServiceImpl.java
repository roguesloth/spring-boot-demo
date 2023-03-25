package com.techie.springbootdemo.service;

import com.techie.springbootdemo.exception.EmployeeNotFoundException;
import com.techie.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements  EmployeeService {


    List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {

        if(employee.getEmployeeId() == null ||
            employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeList.stream()
                .filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst()
                .orElseThrow(()-> new EmployeeNotFoundException("" +
                        "Employee Not found with Id: " + id));
    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee employeeToDelete = employeeList.stream()
                .filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst()
                .get();

        employeeList.remove(employeeToDelete);
        return "Employee Removed with Id: " + employeeToDelete.getEmployeeId();
    }


}
