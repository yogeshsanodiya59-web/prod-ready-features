package com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.cleint;

import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long employeeId);
}
