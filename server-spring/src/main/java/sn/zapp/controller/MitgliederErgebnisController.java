/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.controller;

import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;
import com.canoo.dolphin.server.event.DolphinEventBus;
import com.canoo.dolphin.server.event.Message;
import com.canoo.dolphin.server.event.MessageListener;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import sn.zapp.peristence.converter.StringToSQLDatePersistenceConverter;
import sn.zapp.persistence.MitgliedErgebnisse;
import sn.zapp.persistence.Mitglieder;
import sn.zapp.persistence.MitgliederRepository;
import sn.zappi.common.model.MitgliedErgebnisModel;

/**
 *
 * @author Steppo
 */
@DolphinController("MitgliederErgebnisController")
public class MitgliederErgebnisController {

    @DolphinModel
    private MitgliedErgebnisModel model;

    @Autowired
    private MitgliederRepository mitgliedRepository;

    @Inject
    private StringToSQLDatePersistenceConverter converterString;

    @Inject
    private DolphinEventBus eventBus;

    private Mitglieder mitglied = null;
    
    private String selectedMitglied = null;

    @PostConstruct
    public void init() {
//        eventBus.subscribe("nameClickedAdress", e ->setMitglied(this.mitgliedRepository.findBynachname(e.toString())));
//        eventBus.subscribe("nameClickedAdress", new MessageListener() {
//            @Override
//            public void onMessage(Message message) {
//                System.out.println(message.toString());
//            }
//        });
        Mitglieder mitglied = this.mitgliedRepository.findBynachname("Naus");
//        Set<MitgliedErgebnisse> ergebnisse = mitglied.getMitgliedErgebisse();
        for (MitgliedErgebnisse mitgliedErgebnisse : mitglied.getListeErgebisse()) {
            model.getAlleNeune().set(mitgliedErgebnisse.getAlle_neune());
            model.getTag().set(converterString.convertToDatabaseColumn(mitgliedErgebnisse.getDatum()));
            model.getGesamt().set(mitgliedErgebnisse.getGesamt());
            model.getIdiotenKegeln().set(mitgliedErgebnisse.getIdioten_kegeln());
            model.getKrefelderPartie().set(mitgliedErgebnisse.getKrefelder_partie());
            model.getPudel().set(mitgliedErgebnisse.getPudel());
            model.getTore().set(mitgliedErgebnisse.getTore());
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
