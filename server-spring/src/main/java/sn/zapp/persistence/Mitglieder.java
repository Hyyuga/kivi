/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.persistence;

import java.sql.Date;
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
@Table(name="mitglieder")
public class Mitglieder {
    
 @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String vorname, nachname, adresse;
    private Date geburtstag;
    
    public Mitglieder(){}
    
    public Mitglieder(String kassenzeichen, Date einheitswertnummer, String name, String strasse, String ort, String lagebezeichung){
        this.vorname = kassenzeichen;
        this.geburtstag = einheitswertnummer;
        this.nachname = name;
        this.adresse = strasse;
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
     * @return the vorname
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * @param vorname the vorname to set
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    /**
     * @return the geburtstag
     */
    public Date getGeburtstag() {
        return geburtstag;
    }

    /**
     * @param geburtstag the geburtstag to set
     */
    public void setGeburtstag(Date geburtstag) {
        this.geburtstag = geburtstag;
    }

    /**
     * @return the nachname
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * @param nachname the nachname to set
     */
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
