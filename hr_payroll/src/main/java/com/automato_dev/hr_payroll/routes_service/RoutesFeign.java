package com.automato_dev.hr_payroll.routes_service;


import com.automato_dev.hr_payroll.entity.EmployeeEntity;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "hr-employee", path = "/employees")
public interface RoutesFeign {

    @GetMapping("{id}")
    public ResponseEntity<EmployeeEntity> fetchEmployeeById(@PathVariable("id") Long id);
    
}
