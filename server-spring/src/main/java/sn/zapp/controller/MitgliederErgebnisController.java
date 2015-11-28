/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.controller;

import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;
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
    private MitgliederRepository mitglied;

    @Inject
    private StringToSQLDatePersistenceConverter converterString;

    @PostConstruct
    public void init() {
        Mitglieder mitglied = this.mitglied.findBynachname("Naus");
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
        System.out.println("Init");
    }
}
