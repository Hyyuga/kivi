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

//    private TextField imageURI;
    public MitgliederDialogViewBinder(ClientContext clientContext) {
        super(clientContext, "MitgliederDialogController");
    }

    @Override
    protected void init() {
        FXBinder.bind(txtFieldVorname.textProperty()).bidirectionalTo(getModel().txtFieldVornameProperty());
        FXBinder.bind(txtFieldNachname.textProperty()).bidirectionalTo(getModel().txtFieldNachnameProperty());
        FXBinder.bind(txtFieldAdresse.textProperty()).bidirectionalTo(getModel().txtFieldAdresseProperty());
        FXBinder.bind(datePickerGeb.valueProperty()).bidirectionalTo(getModel().gebDatePickerProperty());
//        FXBinder.bind(imageURI.textProperty()).bidirectionalTo(getModel().imageViewFotoProperty());
        FXBinder.bind(imageViewFoto.imageProperty()).bidirectionalTo(getModel().imageViewFotoProperty());
        btnReset.setOnAction(e -> invoke("reset"));
        btnSave.setOnAction(e -> invoke("save"));
        Image image = new Image(getClass().getResource("/sn/zapp/resources/pictures/lol.JPG").toString());
        imageViewFoto.setImage(image);
//        imageViewFoto.setStyle("-fx-background-color: BLACK");
//        URI uri = null;
//        try {
//            uri = new URI("/sn/zapp/resources/pictures/lol.JPG");
//        } catch (URISyntaxException ex) {
//            Logger.getLogger(MitgliederDialogViewBinder.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        Rectangle clip = new Rectangle(
//                imageViewFoto.getFitWidth(), imageViewFoto.getFitHeight()
//        );
//        clip.setArcWidth(20);
//        clip.setArcHeight(20);
//        imageViewFoto.setClip(clip);
//
//        // snapshot the rounded image.
//        SnapshotParameters parameters = new SnapshotParameters();
//        parameters.setFill(Color.TRANSPARENT);
//        WritableImage image = imageViewFoto.snapshot(parameters, null);
//
//        // remove the rounding clip so that our effect can show through.
//        imageViewFoto.setClip(null);
//
//        // apply a shadow effect.
//        imageViewFoto.setEffect(new DropShadow(20, Color.BLACK));
//
//        // store the rounded image in the imageView.
//        imageViewFoto.setImage(image);

//        File file = new File(uri);
//        Image image = new Image(file.toURI().toString());
//        imageViewFoto.setImage(image);
    }

}
