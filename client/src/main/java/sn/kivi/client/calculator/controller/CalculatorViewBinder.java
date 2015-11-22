/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.client.calculator.controller;

import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.javafx.AbstractViewBinder;
import com.canoo.dolphin.client.javafx.FXBinder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sn.kivi.common.calculator.model.CalculatorModel;

/**
 * FXML Controller class
 *
 * @author Steppo
 */
public class CalculatorViewBinder extends AbstractViewBinder<CalculatorModel>{

    @FXML
    private TextField valueAField;

    @FXML
    private TextField valueBField;

    @FXML
    private TextField resultField;

    @FXML
    private Button resetButton;

    public CalculatorViewBinder(ClientContext clientContext) {
        super(clientContext, "CalculatorController");
    }
    public void init() {
        FXBinder.bind(valueAField.textProperty()).bidirectionalTo(getModel().firstValueProperty());
        FXBinder.bind(valueBField.textProperty()).bidirectionalTo(getModel().secondValueProperty());
        FXBinder.bind(resultField.textProperty()).bidirectionalTo(getModel().resultProperty());
        resetButton.setOnAction(e -> invoke("reset"));
    }
}
