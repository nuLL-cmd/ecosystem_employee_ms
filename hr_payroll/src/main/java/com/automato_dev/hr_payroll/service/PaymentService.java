package com.automato_dev.hr_payroll.service;

import com.automato_dev.hr_payroll.entity.EmployeeEntity;
import com.automato_dev.hr_payroll.entity.Payment;
import com.automato_dev.hr_payroll.routes_service.RoutesFeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private RoutesFeign routesFeign;

    public Payment getPayment(Long idEmployee, int days){

        EmployeeEntity employeeEntity = routesFeign.fetchEmployeeById(idEmployee).getBody();
        return new Payment(employeeEntity.getName(), employeeEntity.getDailyIncome(), days);
    }
}
