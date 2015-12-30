/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zappi.common.model;

import com.canoo.dolphin.mapping.DolphinBean;
import com.canoo.dolphin.mapping.Property;
import javafx.scene.image.Image;

/**
 *
 * @author y9052
 */
@DolphinBean
public class MitgliederDetails {

    private Property<String> txtFieldVorname;

    private Property<String> txtFieldNachname;

    private Property<String> txtFieldAdresse;

    private Property<String> dateString;

    private Property<Image> imageViewFoto;

    public Property<String> txtFieldVornameProperty() {
        return txtFieldVorname;
    }

    public Property<String> txtFieldNachnameProperty() {
        return txtFieldNachname;
    }

    public Property<String> txtFieldAdresseProperty() {
        return txtFieldAdresse;
    }

    public Property<Image> imageViewFotoProperty() {
        return imageViewFoto;
    }
    
    public Property<String> gebDateString() {
        return dateString;
    }

    public String getTxtFieldVorname() {
        return txtFieldVornameProperty().get();
    }

    public String getTxtFieldNachname() {
        return txtFieldNachnameProperty().get();
    }

    public String getTxtAdresse() {
        return txtFieldAdresseProperty().get();
    }
    
    public String getTxtDateField() {
        return gebDateString().get();
    }

    public Image getImageViewFoto() {
        return imageViewFotoProperty().get();
    }
    
    public void setVorname(String kzValue) {
        txtFieldVornameProperty().set(kzValue);
    }
    
    public void setNachname(String ewValue) {
        txtFieldNachnameProperty().set(ewValue);
    }
    
    public void setAdresse(String nameValue) {
        txtFieldAdresseProperty().set(nameValue);
    }
    
    public void setDate(String dateString) {
        gebDateString().set(dateString);
    }
    
    public void setImageViewFoto(Image imageValue) {
        imageViewFotoProperty().set(imageValue);
    }
    
}
