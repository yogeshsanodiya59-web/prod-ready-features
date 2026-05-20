package com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.cleint.impl;

import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.advice.ApiResponse;
import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.cleint.EmployeeClient;
import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.config.RestClientConfig;
import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClient;

import javax.management.relation.RoleInfoNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {


    private final RestClient restClient;

    @Override
    public List<EmployeeDTO> getAllEmployees() {

        try {
            ApiResponse<EmployeeDTO> employeeDTOList = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {


                    });
            return (List<EmployeeDTO>) employeeDTOList.getData();

        } catch (Exception e){
                throw new RuntimeException(e);
        }


    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        try{
                ApiResponse<EmployeeDTO> employeeResponse = restClient.get()
                        .uri("employees/{employeeId}" , employeeId)
                        .retrieve()
                        .body( new ParameterizedTypeReference<>(){
                        });
                return employeeResponse.getData();


        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
