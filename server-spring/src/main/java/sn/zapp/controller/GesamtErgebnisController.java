/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.controller;

import com.canoo.dolphin.BeanManager;
import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;
import com.canoo.dolphin.server.event.TaskExecutor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import sn.zapp.persistence.MitgliedErgebnisse;
import sn.zapp.persistence.Mitglieder;
import sn.zapp.persistence.MitgliederRepository;
import sn.zappi.common.model.ChartData;
import sn.zappi.common.model.GesamtErgebnis;

@DolphinController("GesamtErgebnisController")
public class GesamtErgebnisController {

    @DolphinModel
    private GesamtErgebnis model;

    @Inject
    private MitgliederRepository repository;

    @Inject
    private BeanManager beanManager;

    @Inject
    private TaskExecutor taskExecutor;

    private HashMap<Mitglieder, HashMap<String, Integer>> rawFilterData;

    @PostConstruct
    public void init() {
        model.getSelectedFilter().onChanged(e -> fillModelData(e.getNewValue()));
        rawFilterData = new HashMap();
        for (Mitglieder mitglieder : repository.findAll()) {
            getFilterFields(MitgliedErgebnisse.class).forEach(field -> {
                if (rawFilterData.get(mitglieder) == null) {
                    rawFilterData.put(mitglieder, new HashMap());
                }
                rawFilterData.get(mitglieder).put(field, getFilterResult(mitglieder, field));
            });
        }
    }

    private Integer getFilterResult(Mitglieder mitglied, String filter) {
        return new Integer(mitglied.getListeErgebisse()
                .stream()
                .mapToInt(ergebnis -> getValueOfDeclaredField(filter, ergebnis)).sum());
    }

    private Stream<String> getFilterFields(Class<?> clazz) {
        return Stream.of(clazz.getDeclaredFields())
                .filter(field -> !(field.getName().equals("id") || field.getName().equals("datum") || field.getName().equals("mitglied") || field.getName().equals("strafen")))
                .map(field -> field.getName());
    }

    private Integer getValueOfDeclaredField(String filter, MitgliedErgebnisse mitgliedErgebnisse) {
        Integer retVal = null;
        try {
            Field field = mitgliedErgebnisse.getClass().getDeclaredField(filter);
            field.setAccessible(true);
            retVal = Integer.parseInt((String) field.get(mitgliedErgebnisse));
        } catch (Exception ex) {
            Logger.getLogger(GesamtErgebnisController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retVal;
    }

    void getFilter() {
        getFilterFields(MitgliedErgebnisse.class).forEach(field -> model.getFilter().add(field));
        model.getData().clear();
    }

    public void fillModelData(String filter) {
        model.getData().clear();
        taskExecutor.execute(GesamtErgebnisController.class, e -> {
            rawFilterData.entrySet().stream().map((mitgliedToFilterResultEntry) -> {
                ChartData data = beanManager.create(ChartData.class);
                String datax = mitgliedToFilterResultEntry.getKey().getVorname() + " " + mitgliedToFilterResultEntry.getKey().getNachname();
                data.setCategory(datax);
                Integer datay = mitgliedToFilterResultEntry.getValue().get(filter);
                data.setValue(datay);
                return data;
            }).forEach((data) -> {
                model.getData().add(data);
            });
        });

    }
}
