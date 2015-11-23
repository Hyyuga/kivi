/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.serverspring.calculator.controller;

import com.canoo.dolphin.server.DolphinAction;
import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import sn.kivi.common.calculator.model.CalculatorModel;
import sn.kivi.serverspring.calculator.persistence.entities.Calculator;

@DolphinController("CalculatorController")
public class CalculatorController {

    @DolphinModel
    private CalculatorModel model;

    @Autowired
    private CalculatorRepository repository;
    
    @PostConstruct
    public void init() {
        model.firstValueProperty().onChanged(e -> calc());
        model.secondValueProperty().onChanged(e -> calc());
    }

    @DolphinAction
    public void reset(){
        model.setFirstValue(null);
        model.setSecondValue(null);
        model.setResult(null);
    }
    private void calc() {
        try {
            int valueA = 0;
            int valueB = 0;
            String stringValue = model.getFirstValue();
            if (stringValue != null && !stringValue.trim().isEmpty()) {
                valueA = Integer.parseInt(stringValue);
            }
            stringValue = model.getSecondValue();
            if (stringValue != null && !stringValue.trim().isEmpty()) {
                valueB = Integer.parseInt(stringValue);
            }
            Calculator calc = new Calculator(valueA ,valueB);
            repository.save(calc);
            model.resultProperty().set((valueA + valueB) + "");
        } catch (Exception e) {
            model.resultProperty().set("Error");
        }
    }
}
