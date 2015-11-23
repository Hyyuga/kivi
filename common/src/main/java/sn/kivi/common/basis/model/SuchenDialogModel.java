/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.common.basis.model;

import com.canoo.dolphin.mapping.DolphinBean;
import com.canoo.dolphin.mapping.Property;

/**
 *
 * @author y9052
 */
@DolphinBean
public class SuchenDialogModel {

    private Property<String> txtFieldKZ;

    private Property<String> txtFieldEW;

    private Property<String> txtFieldName;

    private Property<String> txtFieldStrasse;

    private Property<String> txtFieldOrt;

    private Property<String> txtFieldLage;

    public Property<String> txtFieldKZProperty() {
        return txtFieldKZ;
    }

    public Property<String> txtFieldEWProperty() {
        return txtFieldEW;
    }

    public Property<String> txtFieldNameProperty() {
        return txtFieldName;
    }

    public Property<String> txtFieldStrasseProperty() {
        return txtFieldStrasse;
    }

    public Property<String> txtFieldOrtProperty() {
        return txtFieldOrt;
    }

    public Property<String> txtFieldLageProperty() {
        return txtFieldLage;
    }

    public String getTxtFieldKZ() {
        return txtFieldKZProperty().get();
    }

    public String getTxtFieldEW() {
        return txtFieldEWProperty().get();
    }

    public String getTxtFieldName() {
        return txtFieldNameProperty().get();
    }

    public String getTxtFieldStrasse() {
        return txtFieldStrasseProperty().get();
    }

    public String getTxtFieldOrt() {
        return txtFieldOrtProperty().get();
    }
    
    public String getTxtFieldLage() {
        return txtFieldLageProperty().get();
    }

    public void setKassenzeichen(String kzValue) {
        txtFieldKZProperty().set(kzValue);
    }
    
    public void setEWNummer(String ewValue) {
        txtFieldEWProperty().set(ewValue);
    }
    
    public void setName(String nameValue) {
        txtFieldNameProperty().set(nameValue);
    }
    
    public void setStrasse(String strasseValue) {
        txtFieldStrasseProperty().set(strasseValue);
    }
    
    public void setOrt(String ortValue) {
        txtFieldOrtProperty().set(ortValue);
    }
    
    public void setLagebezeichnung(String lageValue) {
        txtFieldLageProperty().set(lageValue);
    }
}
