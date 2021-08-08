package com.automato_dev.hr_payroll.resource;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

import com.automato_dev.hr_payroll.entity.Payment;
import com.automato_dev.hr_payroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("{idEmployee}/days/{days}")
    public ResponseEntity<?> fetchPaymentByEmployee(@PathVariable("idEmployee")Long idEmployee,@PathVariable("days") Integer days){
        Payment payment = paymentService.getPayment(idEmployee, days);
      
        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<?> getPaymentAlternative(Long idEmployee, Integer days){
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Serviço hr-emplyee indisponivel");
        map.put("timestamp", OffsetDateTime.now().toEpochSecond());
        map.put("status",HttpStatus.INTERNAL_SERVER_ERROR);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        
    }


}
