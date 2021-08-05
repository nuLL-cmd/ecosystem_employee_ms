package com.automato_dev.hrEmploye.repository;


import com.automato_dev.hrEmploye.entity.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmplolyeeRepository  extends JpaRepository<EmployeeEntity, Long>{
    
    
}
