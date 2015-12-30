/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.controller;

import com.canoo.dolphin.BeanManager;
import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;
import com.canoo.dolphin.server.event.DolphinEventBus;
import com.canoo.dolphin.server.event.TaskExecutor;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import sn.zapp.persistence.MitgliederRepository;
import sn.zappi.common.model.Master;

/**
 *
 * @author Steppo
 */
@DolphinController("MasterController")
public class MasterController {

    @DolphinModel
    private Master model;

    @Inject
    private MitgliederRepository mitglieder;

    @Inject
    private TaskExecutor taskExecutor;

    @Inject
    private BeanManager beanManager;

    @Inject
    private DolphinEventBus eventbus;
    
    @PostConstruct
    public void init() {
        addMitgliedMenuItem("Gesamt");
        model.selectedEntry().onChanged(e -> {
            clickedNameEntry(model.selectedEntry().get());
        });
        mitglieder.findAll().forEach(mitglied -> addMitgliedMenuItem(mitglied.getNachname()));
        //hier vorerst noch nach dem laden der view das selecteditem on change benutzen um mit dem taskexecutor die andren controller mit den membern zu füllen
//        eventbus.publish("mitglieder", model.getMenuItems());
    }

    private void addMitgliedMenuItem(String text) {
        model.getMenuItems().add(text);
    }

    public void clickedNameEntry(String entry) {
        if (!entry.equals("Gesamt")) {
            taskExecutor.execute(MitgliederDetailsController.class, c -> c.fillModelData(entry));
            taskExecutor.execute(MitgliederErgebnisController.class, c -> c.getSpieltage(entry));
        } else {
            taskExecutor.execute(GesamtErgebnisController.class, c -> c.getFilter());
        }

    }
}
