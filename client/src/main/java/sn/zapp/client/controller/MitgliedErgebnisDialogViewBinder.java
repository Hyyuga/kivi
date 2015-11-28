/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.client.controller;

import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.javafx.AbstractViewBinder;
import com.canoo.dolphin.client.javafx.FXBinder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sn.zappi.common.model.MitgliedErgebnisModel;

/**
 *
 * @author Steppo
 */
public class MitgliedErgebnisDialogViewBinder extends AbstractViewBinder<MitgliedErgebnisModel> {

    public MitgliedErgebnisDialogViewBinder(ClientContext clientContext) {
        super(clientContext, "MitgliederErgebnisController");
    }
    @FXML
    private TextField txtFieldKrefeld;

    @FXML
    private TextField txtFieldBla;

    @FXML
    private TextField txtFieldGesamt;

    @FXML
    private DatePicker datePickerTag;

    @FXML
    private TextField txtFieldPudel;

    @FXML
    private TextField txtFieldNeune;

    @FXML
    private TextField txtFieldTore;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @Override
    protected void init() {
        FXBinder.bind(txtFieldGesamt.textProperty()).bidirectionalTo(getModel().getGesamt());
        FXBinder.bind(txtFieldBla.textProperty()).bidirectionalTo(getModel().getIdiotenKegeln());
        FXBinder.bind(txtFieldKrefeld.textProperty()).bidirectionalTo(getModel().getKrefelderPartie());
        FXBinder.bind(txtFieldNeune.textProperty()).bidirectionalTo(getModel().getAlleNeune());
        FXBinder.bind(txtFieldPudel.textProperty()).bidirectionalTo(getModel().getPudel());
        FXBinder.bind(txtFieldTore.textProperty()).bidirectionalTo(getModel().getTore());
        FXBinder.bind(datePickerTag.getEditor().textProperty()).bidirectionalTo(getModel().getTag());
        btnReset.setOnAction(e -> invoke("reset"));
        btnSave.setOnAction(e -> invoke("save"));
    }

}
