package com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.cleint.impl;

import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.advice.ApiResponse;
import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.cleint.EmployeeClient;
import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.config.RestClientConfig;
import com.codingshuttle.yogesh.prod_ready_features.prod_ready_features.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClient;

import javax.management.relation.RoleInfoNotFoundException;
import java.lang.reflect.Type;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {


    private final RestClient restClient;

    Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);


    @Override
    public List<EmployeeDTO> getAllEmployees() {

        log.error("error log");
        log.error("warn log");
        log.error("info log");
        log.error("debug log");
        log.error("trace log");

        try {
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get()
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {


                    });
            log.debug("Succefully retirvedd the employee in getAllEmployee");
            log.trace("Retrived employeee list in  getAllEmployees" ,  employeeDTOList.getData() , "hello",5);
            return employeeDTOList.getData();


        } catch (Exception e){
            log.error("EXCEPTIONN OCCURED IN getAllEmployees" , e);
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

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        try{
            ApiResponse<EmployeeDTO> employeeDTOApiResponse = restClient.post()
                    .uri("employees")
                    .body(employeeDTO)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeDTOApiResponse.getData();

        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
