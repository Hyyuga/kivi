/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zappi.common.model;

import com.canoo.dolphin.collections.ObservableList;
import com.canoo.dolphin.mapping.DolphinBean;
import com.canoo.dolphin.mapping.Property;

/**
 *
 * @author Steppo
 */
@DolphinBean
public class MitgliedErgebnis {

    private Property<String> krefelderPartie;
    private Property<String> idiotenKegeln;
    private Property<String> gesamt;
    private Property<String> tore;
    private Property<String> pudel;
    private Property<String> kraenze;
    private Property<String> alleNeune;
    private Property<String> strafen;
    private Property<String> tag;
    private Property<Boolean> buttonDisabled;
    private ObservableList<String> tageList;
    /**
     * @return the krefelder_partie
     */
    public Property<String> getKrefelderPartie() {
        return krefelderPartie;
    }

    /**
     * @param krefelderPartie the krefelder_partie to set
     */
    public void setKrefelderPartie(Property<String> krefelderPartie) {
        this.krefelderPartie = krefelderPartie;
    }

    /**
     * @return the idioten_kegeln
     */
    public Property<String> getIdiotenKegeln() {
        return idiotenKegeln;
    }

    /**
     * @param idiotenKegeln the idioten_kegeln to set
     */
    public void setIdiotenKegeln(Property<String> idiotenKegeln) {
        this.idiotenKegeln = idiotenKegeln;
    }

    /**
     * @return the gesamt
     */
    public Property<String> getGesamt() {
        return gesamt;
    }

    /**
     * @param gesamt the gesamt to set
     */
    public void setGesamt(Property<String> gesamt) {
        this.gesamt = gesamt;
    }

    /**
     * @return the tore
     */
    public Property<String> getTore() {
        return tore;
    }

    /**
     * @param tore the tore to set
     */
    public void setTore(Property<String> tore) {
        this.tore = tore;
    }

    /**
     * @return the pudel
     */
    public Property<String> getPudel() {
        return pudel;
    }

    /**
     * @param pudel the pudel to set
     */
    public void setPudel(Property<String> pudel) {
        this.pudel = pudel;
    }

    /**
     * @return the kraenze
     */
    public Property<String> getKraenze() {
        return kraenze;
    }

    /**
     * @param kraenze the kraenze to set
     */
    public void setKraenze(Property<String> kraenze) {
        this.kraenze = kraenze;
    }

    /**
     * @return the alle_neune
     */
    public Property<String> getAlleNeune() {
        return alleNeune;
    }

    /**
     * @param alleNeune the alle_neune to set
     */
    public void setAlleNeune(Property<String> alleNeune) {
        this.alleNeune = alleNeune;
    }

    /**
     * @return the strafen
     */
    public Property<String> getStrafen() {
        return strafen;
    }

    /**
     * @param strafen the strafen to set
     */
    public void setStrafen(Property<String> strafen) {
        this.strafen = strafen;
    }

    /**
     * @return the tag
     */
    public Property<String> getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(Property<String> tag) {
        this.tag = tag;
    }

    /**
     * @return the buttonDisabled
     */
    public Property<Boolean> getButtonDisabled() {
        return buttonDisabled;
    }

    /**
     * @param buttonDisabled the buttonDisabled to set
     */
    public void setButtonDisabled(Property<Boolean> buttonDisabled) {
        this.buttonDisabled = buttonDisabled;
    }

    /**
     * @return the tagAuswahl
     */
    public ObservableList<String> getTagAuswahl() {
        return tageList;
    }

    /**
     * @param tagAuswahl the tagAuswahl to set
     */
    public void setTagAuswahl(ObservableList<String> tagAuswahl) {
        this.tageList = tagAuswahl;
    }

}
