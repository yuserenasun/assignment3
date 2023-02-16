package com.app.employee.service;

import com.app.employee.model.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees;

    public EmployeeService() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read the JSON file and extract the "employee" array
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/json/employee.json"));
            JsonNode employeesNode = rootNode.path("record").path("employee");

            // Convert the "employee" array to a List<Employee>
            employees = objectMapper.convertValue(employeesNode, new TypeReference<List<Employee>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}

