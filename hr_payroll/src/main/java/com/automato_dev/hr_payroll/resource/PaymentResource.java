package com.automato_dev.hr_payroll.resource;

import com.automato_dev.hr_payroll.entity.Payment;
import com.automato_dev.hr_payroll.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payments")
public class PaymentResource {
    
    @Autowired
    private PaymentService paymentService;


    @GetMapping("{idEmployee}/days/{days}")
    public ResponseEntity<?> fetchPaymentByEmployee(@PathVariable("idEmployee")Long idEmployee,@PathVariable("days") Integer days){
        Payment payment = paymentService.getPayment(idEmployee, days);

        return ResponseEntity.ok(payment);
    }


}
