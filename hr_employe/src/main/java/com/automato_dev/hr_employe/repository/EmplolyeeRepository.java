package com.automato_dev.hr_employe.repository;

import com.automato_dev.hr_employe.entity.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmplolyeeRepository  extends JpaRepository<EmployeeEntity, Long>{
    
    
}
