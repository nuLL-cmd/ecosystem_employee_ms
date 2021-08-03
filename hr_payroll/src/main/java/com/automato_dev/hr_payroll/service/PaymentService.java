package com.automato_dev.hr_payroll.service;

import java.util.HashMap;
import java.util.Map;

import com.automato_dev.hr_payroll.entity.EmployeeEntity;
import com.automato_dev.hr_payroll.entity.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    @Value("${hr-employee.host}")
    private String employeeHost;


    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(Long idEmployee, int days){

        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(idEmployee));
        EmployeeEntity employeeEntity = restTemplate.getForObject(employeeHost+"/employees/{id}", EmployeeEntity.class, params);

        return new Payment(employeeEntity.getName(), employeeEntity.getDailyIncome(), days);
    }
}
