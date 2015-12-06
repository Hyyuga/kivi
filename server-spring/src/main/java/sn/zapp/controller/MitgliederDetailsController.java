/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.controller;

import com.canoo.dolphin.server.DolphinAction;
import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import sn.zapp.persistence.Mitglieder;
import sn.zapp.persistence.MitgliederRepository;
import sn.zapp.peristence.converter.StringToSQLDatePersistenceConverter;
import sn.zappi.common.model.MitgliederDetailsModel;

/**
 *
 * @author y9052
 */
@DolphinController("MitgliederDetailsController")
public class MitgliederDetailsController {

    @DolphinModel
    private MitgliederDetailsModel model;
    
    @Inject
    private MitgliederRepository repository;

    @Inject
    private StringToSQLDatePersistenceConverter converterString;

    private Mitglieder mitglied = null;
    
    private String selectedMitglied = null;
    
    @PostConstruct
    public void init() {
    }
    
    public void fillModelData(String text){
        setMitglied(repository.findBynachname(text));
        String dateString = converterString.convertToDatabaseColumn(getMitglied().getGeburtstag());
        model.setVorname(getMitglied().getVorname());
        model.setNachname(getMitglied().getNachname());
        model.setAdresse(getMitglied().getAdresse());
        model.setDate(dateString);
    }
    
    @DolphinAction
    public void reset() {
        model.setVorname("Resetted");
        model.setNachname(null);
        model.setAdresse(null);
        model.setDate(null);
    }

    @DolphinAction
    public void save() {
        try {
            Mitglieder mitgliederResult = repository.findOne(getMitglied().getId());
            mitgliederResult.setAdresse(model.getTxtAdresse());
            mitgliederResult.setNachname(model.getTxtFieldNachname());
            mitgliederResult.setVorname(model.getTxtFieldVorname());
            String string = model.gebDateString().get();
            mitgliederResult.setGeburtstag(converterString.convertToEntityAttribute(string));
            repository.save(mitgliederResult);
        } catch (Exception e) {
            model.setVorname("Error");
        }
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
     * @return the nachname
     */
    public String getSelectedMitglied() {
        return selectedMitglied;
    }

    /**
     * @param selectedMitglied the nachname to set
     */
    public void setSelectedMitglied(String selectedMitglied) {
        this.selectedMitglied = selectedMitglied;
    }

}
