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
import com.canoo.dolphin.server.event.TaskExecutor;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import sn.zappi.common.model.MasterModel;
import sn.zappi.common.model.MenuItem;

/**
 *
 * @author Steppo
 */
@DolphinController("MasterController")
public class MasterController {

    @DolphinModel
    private MasterModel model;

    @PostConstruct
    public void init() {
        add("First");
        add("Second");
        add("Third");
    }

    @Inject
    private TaskExecutor taskExecutor;
    @Inject
    private BeanManager beanManager;

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
    public void add(String item) {
        onAdded(item);
//        taskExecutor.execute(MasterController.class, c -> c.onAdded(item));
    }

    private void onAdded(String text) {
        final MenuItem toDoItem = beanManager.create(MenuItem.class);
        toDoItem.setText(text);
        model.getMenuItems().add(toDoItem);
    }
    
//    @DolphinAction
//    public void clicked()
    
}
