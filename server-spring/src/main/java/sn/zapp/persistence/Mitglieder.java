/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.persistence;

import com.mysql.jdbc.Blob;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author Steppo
 */
@Entity
@Table(name = "mitglieder")
public class Mitglieder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String vorname, nachname, adresse, imageurl;
    private Date geburtstag;
    @Lob
    private Blob imagedata;

    @Lob
    private java.sql.Blob imagedatablob;

    public Mitglieder() {
    }

    public Mitglieder(String vorname, String nachname, Date geburtstag, String adresse, String imageUrl, Blob imageData) {
        this.vorname = vorname;
        this.geburtstag = geburtstag;
        this.nachname = nachname;
        this.adresse = adresse;
        this.imageurl = imageUrl;
        this.imagedata = imageData;
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

    /**
     * @return the imageurl
     */
    public String getImageurl() {
        return imageurl;
    }

    /**
     * @param imageurl the imageurl to set
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    /**
     * @return the imagedata
     */
    public Blob getImagedata() {
        return imagedata;
    }

    /**
     * @param imagedata the imagedata to set
     */
    public void setImagedata(Blob imagedata) {
        this.imagedata = imagedata;
    }

    /**
     * @return the imagedatablob
     */
    public java.sql.Blob getImagedatablob() {
        return imagedatablob;
    }

    /**
     * @param imagedatablob the imagedatablob to set
     */
    public void setImagedatablob(java.sql.Blob imagedatablob) {
        this.imagedatablob = imagedatablob;
    }
}
