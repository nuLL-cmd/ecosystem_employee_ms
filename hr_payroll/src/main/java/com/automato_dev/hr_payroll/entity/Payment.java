package com.automato_dev.hr_payroll.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String name;
    private Double dailyIncome;
    private int days;


    public double getTotal(){

        return days * dailyIncome;
    }

}
