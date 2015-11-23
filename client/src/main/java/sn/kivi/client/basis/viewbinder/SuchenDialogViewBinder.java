/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.client.basis.viewbinder;

import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.javafx.AbstractViewBinder;
import com.canoo.dolphin.client.javafx.FXBinder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sn.kivi.common.basis.model.SuchenDialogModel;

/**
 *
 * @author y9052
 */
public class SuchenDialogViewBinder extends AbstractViewBinder<SuchenDialogModel> {

    @FXML
    private TextField txtFieldKZ;

    @FXML
    private TextField txtFieldEW;

    @FXML
    private TextField txtFieldName;

    @FXML
    private TextField txtFieldStrasse;

    @FXML
    private TextField txtFieldOrt;

    @FXML
    private TextField txtFieldLage;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;
     
    
    public SuchenDialogViewBinder(ClientContext clientContext) {
        super(clientContext, "SuchenDialogController");
    }

    @Override
    protected void init() {
        FXBinder.bind(txtFieldKZ.textProperty()).bidirectionalTo(getModel().txtFieldKZProperty());
        FXBinder.bind(txtFieldEW.textProperty()).bidirectionalTo(getModel().txtFieldEWProperty());
        FXBinder.bind(txtFieldName.textProperty()).bidirectionalTo(getModel().txtFieldNameProperty());
        FXBinder.bind(txtFieldStrasse.textProperty()).bidirectionalTo(getModel().txtFieldStrasseProperty());
        FXBinder.bind(txtFieldOrt.textProperty()).bidirectionalTo(getModel().txtFieldOrtProperty());
        FXBinder.bind(txtFieldLage.textProperty()).bidirectionalTo(getModel().txtFieldLageProperty());
        btnReset.setOnAction(e -> invoke("reset"));
        btnSave.setOnAction(e -> invoke("save"));
    }

}
