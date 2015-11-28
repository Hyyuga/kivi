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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sn.zapp.client.app.Zapp;
import sn.zappi.common.model.MitgliederDialogModel;

public class MitgliederDialogViewBinder extends AbstractViewBinder<MitgliederDialogModel> {

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

    public MitgliederDialogViewBinder(ClientContext clientContext) {
        super(clientContext, "MitgliederDialogController");
    }

    @Override
    protected void init() {
        FXBinder.bind(txtFieldVorname.textProperty()).bidirectionalTo(getModel().txtFieldVornameProperty());
        FXBinder.bind(txtFieldNachname.textProperty()).bidirectionalTo(getModel().txtFieldNachnameProperty());
        FXBinder.bind(txtFieldAdresse.textProperty()).bidirectionalTo(getModel().txtFieldAdresseProperty());
        FXBinder.bind(datePickerGeb.getEditor().textProperty()).bidirectionalTo(getModel().gebDateString());
        FXBinder.bind(imageViewFoto.imageProperty()).bidirectionalTo(getModel().imageViewFotoProperty());
        btnReset.setOnAction(e -> invoke("reset"));
        btnSave.setOnAction(e -> invoke("save"));
//        Zapp.getClientContext().getBeanManager().create(beanClass)
//        String imageSource = "http://imgur.com/gallery/UBLi3O3";

//        ImageView imageView = ImageViewBuilder.create()
//                .image(new Image(imageSource))
//                .build();
//        imageView.setImage(imageView.getImage());
//        Image image;
//        try {
//            image = new Image(new URL("http://imgur.com/gallery/UBLi3O3").toString());
//            imageViewFoto.setImage(image);
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(MitgliederDialogViewBinder.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        Image image = new Image(getClass().getResource("/sn/zapp/resources/pictures/lol.JPG").toString());
        imageViewFoto.setImage(image);
    }

}
