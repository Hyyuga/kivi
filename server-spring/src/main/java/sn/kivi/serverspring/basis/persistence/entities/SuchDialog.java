/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.serverspring.basis.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Steppo
 */
@Entity
@Table(name="suchdialog")
public class SuchDialog {
    
 @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String kassenzeichen, einheitswertnummer, name, strasse, ort, lagebezeichung;
    
    public SuchDialog(){}
    
    public SuchDialog(String kassenzeichen, String einheitswertnummer, String name, String strasse, String ort, String lagebezeichung){
        this.kassenzeichen = kassenzeichen;
        this.einheitswertnummer = einheitswertnummer;
        this.name = name;
        this.strasse = strasse;
        this.ort = ort;
        this.lagebezeichung = lagebezeichung;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the kassenzeichen
     */
    public String getKassenzeichen() {
        return kassenzeichen;
    }

    /**
     * @param kassenzeichen the kassenzeichen to set
     */
    public void setKassenzeichen(String kassenzeichen) {
        this.kassenzeichen = kassenzeichen;
    }

    /**
     * @return the einheitswertnummer
     */
    public String getEinheitswertnummer() {
        return einheitswertnummer;
    }

    /**
     * @param einheitswertnummer the einheitswertnummer to set
     */
    public void setEinheitswertnummer(String einheitswertnummer) {
        this.einheitswertnummer = einheitswertnummer;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the strasse
     */
    public String getStrasse() {
        return strasse;
    }

    /**
     * @param strasse the strasse to set
     */
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    /**
     * @return the ort
     */
    public String getOrt() {
        return ort;
    }

    /**
     * @param ort the ort to set
     */
    public void setOrt(String ort) {
        this.ort = ort;
    }

    /**
     * @return the lagebezeichung
     */
    public String getLagebezeichung() {
        return lagebezeichung;
    }

    /**
     * @param lagebezeichung the lagebezeichung to set
     */
    public void setLagebezeichung(String lagebezeichung) {
        this.lagebezeichung = lagebezeichung;
    }
}
