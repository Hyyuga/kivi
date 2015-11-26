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
        add(mitglieder.findOne(1).getVorname());
        add(mitglieder.findOne(2).getVorname());
        add(mitglieder.findOne(3).getVorname());
    }
    @Inject
    private BeanManager beanManager;
    
    public void add(String item) {
//        onAdded(item);
        taskExecutor.execute(MasterController.class, c -> c.onAdded(item));
    }
    private void onAdded(String text) {
        final MenuItemEntry toDoItem = beanManager.create(MenuItemEntry.class);
        toDoItem.setText(text);
        model.getMenuItems().add(toDoItem);
    }
    @DolphinAction("clicked")
    public void clicked(@Param("name") String item){//, @Param("row") int row) {
        model.getMenuItems().get(0).setText(item);
    }
    
    @Inject
    private TaskExecutor taskExecutor;
//    @DolphinAction
//    public void clicked()
    //    public void createTreeView() {
//        //create root
//        TreeItem<String> root = new TreeItem<>("Root");
//        //root.setExpanded(true);
//        //create child
//        TreeItem<String> itemChild = new TreeItem<>("Child");
//        itemChild.setExpanded(false);
//        //root is the parent of itemChild
//        root.getChildren().add(itemChild);
//        model.treeViewMenu().setRoot(root);
//    }
    //    @DolphinAction
//    public void addasd(){
//        Mitglieder mitglied = new Mitglieder("Steffen", new Date(1983, 6, 16), "Naus", "Florianstrasse 28");
//        Mitglieder mitglied1 = new Mitglieder("Martin", new Date(1982, 4, 16), "Nyaki", "Tulpenweg 58");
//        Mitglieder mitglied2 = new Mitglieder("Christian", new Date(1980, 1, 6), "Ossowski", "Holtweg 67");
//        mitglieder.save(mitglied);
//        mitglieder.save(mitglied1);
//        mitglieder.save(mitglied2);
//    }
}
