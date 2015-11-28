/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.controller;

import com.canoo.dolphin.BeanManager;
import com.canoo.dolphin.mapping.Property;
import com.canoo.dolphin.server.DolphinAction;
import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;
import java.time.LocalDate;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import sn.zapp.persistence.Mitglieder;
import sn.zapp.persistence.MitgliederRepository;
import sn.zapp.peristence.converter.LocalDatePersistenceConverter;
import sn.zapp.peristence.converter.StringToSQLDatePersistenceConverter;
import sn.zapp.persistence.MitgliedErgebnisse;
import sn.zappi.common.model.MitgliederDialogModel;

/**
 *
 * @author y9052
 */
@DolphinController("MitgliederDialogController")
public class MitgliederDialogController {

    @DolphinModel
    private MitgliederDialogModel model;

    @Autowired
    private MitgliederRepository repository;

    private Mitglieder mitglied = null;

    @Inject
    private BeanManager beanManager;

    @Inject
    private LocalDatePersistenceConverter converter;

    @Inject
    private StringToSQLDatePersistenceConverter converterString;

    @PostConstruct
    public void init() {
        mitglied = repository.findBynachname("Naus");
        Property<String> s = model.txtFieldAdresseProperty();
        LocalDate date = converter.convertToDatabaseColumn(mitglied.getGeburtstag());
        String dateString = converterString.convertToDatabaseColumn(mitglied.getGeburtstag());
        model.setVorname(mitglied.getVorname());
        model.setNachname(mitglied.getNachname());
        model.setAdresse(mitglied.getAdresse());
        model.setDate(dateString);
        //this code thows only managed beans can be used
//        model.setGebDate(date);
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
            Mitglieder mitgliederResult = repository.findOne(mitglied.getId());
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

}
