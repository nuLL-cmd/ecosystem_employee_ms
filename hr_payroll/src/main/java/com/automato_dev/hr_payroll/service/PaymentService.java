package com.automato_dev.hr_payroll.service;

import com.automato_dev.hr_payroll.entity.Payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {


    public Payment getPayment(Long idEmployee, int days){

        return new Payment("Bob", 200.0, days);
    }
}
