/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.controller;

import com.canoo.dolphin.collections.ObservableList;
import com.canoo.dolphin.impl.collections.ObservableArrayList;
import com.canoo.dolphin.server.DolphinAction;
import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;
import com.canoo.dolphin.server.Param;
import com.canoo.dolphin.server.event.DolphinEventBus;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import sn.zapp.peristence.converter.StringToSQLDatePersistenceConverter;
import sn.zapp.persistence.MitgliedErgebnisse;
import sn.zapp.persistence.MitgliedErgebnisseRepository;
import sn.zapp.persistence.Mitglieder;
import sn.zapp.persistence.MitgliederRepository;
import sn.zappi.common.model.MitgliedErgebnis;

/**
 *
 * @author Steppo
 */
@DolphinController("MitgliederErgebnisController")
public class MitgliederErgebnisController {

    @DolphinModel
    private MitgliedErgebnis model;

    @Autowired
    private MitgliederRepository mitgliedRepository;

    @Autowired
    private MitgliedErgebnisseRepository mitgliedErgebnisRepository;

    @Inject
    private StringToSQLDatePersistenceConverter converterString;

    private Mitglieder mitglied = null;

    private Set<MitgliedErgebnisse> ergebnisse;

    private String selectedMitglied = null;

    @Inject
    private DolphinEventBus eventbus;

    private List list = new ObservableArrayList();

    @PostConstruct
    public void init() {
//        eventbus.subscribe("mitglieder", e -> addMitglieder((ObservableList<String>) e.getData()));
//        System.out.println("sn.zapp.controller.MitgliederErgebnisController.init()");
    }

    private void addSpielTag(String text) {
        model.getTagAuswahl().add(text);
    }

    private void addMitglieder(ObservableList<String> text) {
        list.addAll(text);
    }

    public void getSpieltage(String text) {
        this.mitglied = this.mitgliedRepository.findBynachname(text);
        mitglied.getListeErgebisse().forEach((MitgliedErgebnisse ergebnis) -> addSpielTag(converterString.convertToDatabaseColumn(ergebnis.getDatum())));
        mitglied.getListeErgebisse().forEach((MitgliedErgebnisse ergebnis) -> getErgebnisse().add(ergebnis));
    }

    @DolphinAction
    public void save() {
        try {
            MitgliedErgebnisse mitgliedErgebnisse = mitgliedErgebnisRepository.findBydatum(converterString.convertToEntityAttribute(model.getTag().get()));
            if (mitgliedErgebnisse == null) {
                mitgliedErgebnisse = new MitgliedErgebnisse();
            }
            mitgliedErgebnisse.setAlle_neune(model.getAlleNeune().get());
            mitgliedErgebnisse.setDatum(converterString.convertToEntityAttribute(model.getTag().get()));
            mitgliedErgebnisse.setGesamt(model.getGesamt().get());
            mitgliedErgebnisse.setKraenze(model.getKraenze().get());
            mitgliedErgebnisse.setIdioten_kegeln(model.getIdiotenKegeln().get());
            mitgliedErgebnisse.setPudel(model.getPudel().get());
            mitgliedErgebnisse.setTore(model.getTore().get());
            mitgliedErgebnisse.setKrefelder_partie(model.getKrefelderPartie().get());
            mitgliedErgebnisse.setMitglied(this.mitglied);
            mitgliedErgebnisRepository.save(mitgliedErgebnisse);
        } catch (Exception e) {
            model.getTag().set("Error");
        }
    }

    @DolphinAction
    public void fillModelData(@Param("tag") String date) {
        MitgliedErgebnisse filterErgebnis = getErgebnisse().stream().filter((MitgliedErgebnisse ergebnis) -> converterString.convertToDatabaseColumn(ergebnis.getDatum()).equals(date)).findFirst().get();
        model.getAlleNeune().set(filterErgebnis.getAlle_neune());
        model.getTag().set(converterString.convertToDatabaseColumn(filterErgebnis.getDatum()));
        model.getGesamt().set(filterErgebnis.getGesamt());
        model.getIdiotenKegeln().set(filterErgebnis.getIdioten_kegeln());
        model.getKrefelderPartie().set(filterErgebnis.getKrefelder_partie());
        model.getPudel().set(filterErgebnis.getPudel());
        model.getTore().set(filterErgebnis.getTore());
        model.getKraenze().set(filterErgebnis.getKraenze());
    }

    @DolphinAction
    public void reset() {
        model.getAlleNeune().set(null);
        model.getTag().set(null);
        model.getGesamt().set(null);
        model.getIdiotenKegeln().set(null);
        model.getKrefelderPartie().set(null);
        model.getPudel().set(null);
        model.getTore().set(null);
        model.getKraenze().set(null);
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

    /**
     * @return the ergebnisse
     */
    public Set<MitgliedErgebnisse> getErgebnisse() {
        if (ergebnisse == null) {
            ergebnisse = new HashSet<>();
        }
        return ergebnisse;
    }

    /**
     * @param ergebnisse the ergebnisse to set
     */
    public void setErgebnisse(Set<MitgliedErgebnisse> ergebnisse) {
        this.ergebnisse = ergebnisse;
    }
}
