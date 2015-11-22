/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.serverspring.calculator.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Steppo
 */
@Entity
@Table(name = "calculator")
public class Calculator {
 
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private Integer firstValue, secondValue, result;
    
//    public List<Calculator> findAll(Integer result){
//        return null;
//    }
    
    public Calculator(){}
    
    public Calculator(Integer firstValue, Integer secondValue){
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.result = firstValue + secondValue;
    }
    
}
