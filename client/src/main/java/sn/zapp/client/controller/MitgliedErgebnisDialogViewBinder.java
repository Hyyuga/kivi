/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.client.controller;

import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.Param;
import com.canoo.dolphin.client.javafx.AbstractViewBinder;
import com.canoo.dolphin.client.javafx.FXBinder;
import com.canoo.dolphin.client.javafx.FXWrapper;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sn.zappi.common.model.MitgliedErgebnis;

/**
 *
 * @author Steppo
 */
public class MitgliedErgebnisDialogViewBinder extends AbstractViewBinder<MitgliedErgebnis> {

    @FXML
    private ComboBox<String> comboBoxAuswahl;

    @FXML
    private TextField txtFieldKrefeld;

    @FXML
    private TextField txtFieldIdiot;

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
    private TextField txtFieldKraenze;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    public MitgliedErgebnisDialogViewBinder(ClientContext clientContext) {
        super(clientContext, "MitgliederErgebnisController");
    }

    @Override
    protected void init() {
        FXBinder.bind(txtFieldGesamt.textProperty()).bidirectionalTo(getModel().getGesamt());
        FXBinder.bind(txtFieldIdiot.textProperty()).bidirectionalTo(getModel().getIdiotenKegeln());
        FXBinder.bind(txtFieldKrefeld.textProperty()).bidirectionalTo(getModel().getKrefelderPartie());
        FXBinder.bind(txtFieldNeune.textProperty()).bidirectionalTo(getModel().getAlleNeune());
        FXBinder.bind(txtFieldPudel.textProperty()).bidirectionalTo(getModel().getPudel());
        FXBinder.bind(txtFieldTore.textProperty()).bidirectionalTo(getModel().getTore());
        FXBinder.bind(datePickerTag.getEditor().textProperty()).bidirectionalTo(getModel().getTag());
        FXBinder.bind(txtFieldKraenze.textProperty()).bidirectionalTo(getModel().getKraenze());
        ObservableList<String> list = FXWrapper.wrapList(getModel().getTagAuswahl());
        comboBoxAuswahl.setItems(list);
        //TODO: hier noch selected tag ins model und darauf das onchanged event im cotroller anbringen
        comboBoxAuswahl.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String oldValue, String newValue) {
                invoke("fillModelData", new Param("tag", newValue));
            }
        });
        BooleanProperty buttonDisabled = new SimpleBooleanProperty();
        buttonDisabled.bind(txtFieldGesamt.textProperty().isEmpty());
        btnSave.disableProperty().bind(buttonDisabled);
        btnReset.setOnAction(e -> invoke("reset"));
        btnSave.setOnAction(e -> invoke("save"));
    }

}
