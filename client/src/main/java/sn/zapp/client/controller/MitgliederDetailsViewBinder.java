/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.client.controller;

import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.javafx.AbstractViewBinder;
import com.canoo.dolphin.client.javafx.FXBinder;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import sn.kivi.client.util.ViewState;
import sn.zappi.common.model.MenuItemEntry;
import sn.zappi.common.model.MitgliederDetails;

public class MitgliederDetailsViewBinder extends AbstractViewBinder<MitgliederDetails> {

    @FXML
    private TextField txtFieldVorname;

    @FXML
    private TextField txtFieldNachname;

    @FXML
    private TextField txtFieldAdresse;

    @FXML
    private DatePicker datePickerGeb;

    @FXML
    private ImageView imageViewFoto;
    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;
    
    private MenuItemEntry mitglied;
    
    private ViewState viewState;
    
    public MitgliederDetailsViewBinder(ClientContext clientContext, ViewState state) {
        super(clientContext, "MitgliederDetailsController");
        viewState = state;
    }

    @Override
    protected void init() {
        FXBinder.bind(txtFieldVorname.textProperty()).bidirectionalTo(getModel().txtFieldVornameProperty());
        FXBinder.bind(txtFieldNachname.textProperty()).bidirectionalTo(getModel().txtFieldNachnameProperty());
        FXBinder.bind(txtFieldAdresse.textProperty()).bidirectionalTo(getModel().txtFieldAdresseProperty());
        FXBinder.bind(datePickerGeb.getEditor().textProperty()).bidirectionalTo(getModel().gebDateString());
        FXBinder.bind(imageViewFoto.imageProperty()).bidirectionalTo(getModel().imageViewFotoProperty());
        
        
        txtFieldAdresse.setDisable(viewState == ViewState.Member);
        txtFieldNachname.setDisable(viewState == ViewState.Member);
        txtFieldVorname.setDisable(viewState == ViewState.Member);
        datePickerGeb.setDisable(viewState == ViewState.Member);
        btnSave.setVisible(viewState != ViewState.Member);
        btnReset.setVisible(viewState != ViewState.Member);
        btnReset.setOnAction(e -> invoke("reset"));
        btnSave.setOnAction(e -> invoke("save"));
        
        
//        Image image = new Image(getClass().getResource("/sn/zapp/resources/pictures/lol.JPG").toString());
//        imageViewFoto.setImage(image);
    }

    /**
     * @return the mitglied
     */
    public MenuItemEntry getMitglied() {
        return mitglied;
    }

    /**
     * @param mitglied the mitglied to set
     */
    public void setMitglied(MenuItemEntry mitglied) {
        this.mitglied = mitglied;
    }

}
