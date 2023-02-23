package com.app.employee.service;

import com.app.employee.model.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees;
    private final ObjectMapper objectMapper;

    public EmployeeService() {
        this.objectMapper = new ObjectMapper();
        try {
            // Read the JSON file and extract the "student" array
            JsonNode rootNode = this.objectMapper.readTree(new File("src/main/resources/json/student.json"));
            JsonNode employeesNode = rootNode.path("record").path("studentMarks");

            // Convert the "student" array to a List<Employee>
            employees = objectMapper.convertValue(employeesNode, new TypeReference<List<Employee>>(){});
        } catch (IOException e) {
            throw new RuntimeException("Error reading employee data from file", e);
        }
    }

    private List<Employee> calculateTotalAndRank(List<Employee> employees) {
        // Calculate total mark for each employee
        for (Employee employee : employees) {
            int totalMark = employee.getLanguage() + employee.getMaths() + employee.getPhysics() + employee.getScience();
            employee.setTotal(totalMark);
        }

        // Sort employees by total mark in descending order
        Collections.sort(employees, Comparator.comparing(Employee::getTotal).reversed());

        // Assign ranks to the employees
        int rank = 1;
        employees.get(0).setRank(rank);
        for (int i = 1; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            Employee prevEmployee = employees.get(i-1);
            if (employee.getTotal() < prevEmployee.getTotal()) {
                employee.setRank(i+1);
            } else {
                employee.setRank(prevEmployee.getRank());
            }
        }
        return employees;
    }

    public List<Employee> getAllEmployees() {
        return calculateTotalAndRank(employees);
    }
}
