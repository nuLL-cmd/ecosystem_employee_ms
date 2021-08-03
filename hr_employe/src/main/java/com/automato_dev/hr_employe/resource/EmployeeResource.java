package com.automato_dev.hr_employe.resource;

import com.automato_dev.hr_employe.entity.EmployeeEntity;
import com.automato_dev.hr_employe.repository.EmplolyeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employees")
public class EmployeeResource {
    
    @Autowired
    private EmplolyeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<Object> fetchAllEmplyoees(){

        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> fetchEmployeeById(@PathVariable("id") Long id){
        
        return ResponseEntity.ok(employeeRepository.findById(id).orElse(new EmployeeEntity()));
       
    }


    
}
