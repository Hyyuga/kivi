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
import org.springframework.beans.factory.annotation.Autowired;
import sn.zapp.persistence.Mitglieder;
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

    @Autowired
    private MitgliederRepository mitglieder;

    @PostConstruct
    public void init() {
        for (Mitglieder next : mitglieder.findAll()) {
            add(next.getVorname());
        }
    }
    @Inject
    private BeanManager beanManager;

    @Inject
    private TaskExecutor taskExecutor;

    public void add(String item) {
        taskExecutor.execute(MasterController.class, c -> c.onAdded(item));
    }

    private void onAdded(String text) {
        final MenuItemEntry toDoItem = beanManager.create(MenuItemEntry.class);
        toDoItem.setText(text);
        model.getMenuItems().add(toDoItem);
    }

    @DolphinAction("clicked")
    //CONTROLLER_ACTION_CALL_ERROR_BEAN error
    public void clicked(@Param("name") String item, @Param("row") int row) {
        model.getMenuItems().get(row).setText(item);
    }

}
