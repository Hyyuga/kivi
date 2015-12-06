/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.controller;

import com.canoo.dolphin.BeanManager;
import com.canoo.dolphin.server.DolphinAction;
import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;
import com.canoo.dolphin.server.Param;
import com.canoo.dolphin.server.event.TaskExecutor;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import sn.zapp.persistence.MitgliederRepository;
import sn.zappi.common.model.MasterModel;
import sn.zappi.common.model.MenuItemEntry;

/**
 *
 * @author Steppo
 */
@DolphinController("MasterController")
public class MasterController {

    @DolphinModel
    private MasterModel model;

    @Inject
    private MitgliederRepository mitglieder;

    @Inject
    private TaskExecutor taskExecutor;

    @Inject
    private BeanManager beanManager;

    @PostConstruct
    public void init() {
        addMitgliedMenuItem("Gesamt");
        mitglieder.findAll().forEach(mitglied -> addMitgliedMenuItem(mitglied.getNachname()));
    }

    private void addMitgliedMenuItem(String text) {
        final MenuItemEntry nameEntry = beanManager.create(MenuItemEntry.class);
        nameEntry.setText(text);
        model.getMenuItems().add(nameEntry);
    }

    @DolphinAction("clickedNameEntry")
    public void clickedNameEntry(@Param("name") MenuItemEntry entry) {
        if (!entry.getText().equals("Gesamt")) {
            taskExecutor.execute(MitgliederDetailsController.class, c -> c.fillModelData(entry.getText()));
            taskExecutor.execute(MitgliederErgebnisController.class, c -> c.getSpieltage(entry.getText()));
        }else taskExecutor.execute(GesamtErgebnisController.class, c -> c.getFilter());

    }
}
