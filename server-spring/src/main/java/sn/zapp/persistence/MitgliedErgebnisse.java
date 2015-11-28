/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.persistence;

import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "mitglieder_ergebnisse")
public class MitgliedErgebnisse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ergebnis_id")
    private Integer id;
    
    private Date datum;
    
    private String krefelder_partie, idioten_kegeln, gesamt, tore, pudel, kraenze, alle_neune, strafen = "";
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mitglied_id", nullable = false)
    private Mitglieder mitglied;
    
    public MitgliedErgebnisse(){}
    
    public MitgliedErgebnisse(Date datum, String krefeld, String idiot, String gesamt, String tore, String pudel, String kraenze, String alleNeune, String strafen){
        this.alle_neune = alleNeune;
        this.datum = datum;
        this.krefelder_partie = krefeld;
        this.idioten_kegeln = idiot;
        this.gesamt = gesamt;
        this.tore = tore;
        this.pudel = pudel;
        this.kraenze = kraenze;
        this.alle_neune = alleNeune;
        this.strafen = strafen;
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
     * @return the datum
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    /**
     * @return the strafen
     */
    public String getStrafen() {
        return strafen;
    }

    /**
     * @param strafen the strafen to set
     */
    public void setStrafen(String strafen) {
        this.strafen = strafen;
    }

    /**
     * @return the mitglied
     */
    public Mitglieder getMitglied() {
        return mitglied;
    }

    /**
     * @param mitglied the mitglied to set
     */
    public void setMitglied(Mitglieder mitglied) {
        this.mitglied = mitglied;
    }

    /**
     * @return the krefelder_partie
     */
    public String getKrefelder_partie() {
        return krefelder_partie;
    }

    /**
     * @param krefelder_partie the krefelder_partie to set
     */
    public void setKrefelder_partie(String krefelder_partie) {
        this.krefelder_partie = krefelder_partie;
    }

    /**
     * @return the idioten_kegeln
     */
    public String getIdioten_kegeln() {
        return idioten_kegeln;
    }

    /**
     * @param idioten_kegeln the idioten_kegeln to set
     */
    public void setIdioten_kegeln(String idioten_kegeln) {
        this.idioten_kegeln = idioten_kegeln;
    }

    /**
     * @return the gesamt
     */
    public String getGesamt() {
        return gesamt;
    }

    /**
     * @param gesamt the gesamt to set
     */
    public void setGesamt(String gesamt) {
        this.gesamt = gesamt;
    }

    /**
     * @return the tore
     */
    public String getTore() {
        return tore;
    }

    /**
     * @param tore the tore to set
     */
    public void setTore(String tore) {
        this.tore = tore;
    }

    /**
     * @return the pudel
     */
    public String getPudel() {
        return pudel;
    }

    /**
     * @param pudel the pudel to set
     */
    public void setPudel(String pudel) {
        this.pudel = pudel;
    }

    /**
     * @return the kraenze
     */
    public String getKraenze() {
        return kraenze;
    }

    /**
     * @param kraenze the kraenze to set
     */
    public void setKraenze(String kraenze) {
        this.kraenze = kraenze;
    }

    /**
     * @return the alle_neune
     */
    public String getAlle_neune() {
        return alle_neune;
    }

    /**
     * @param alle_neune the alle_neune to set
     */
    public void setAlle_neune(String alle_neune) {
        this.alle_neune = alle_neune;
    }
}
