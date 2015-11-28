/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zappi.common.model;

import com.canoo.dolphin.collections.ObservableList;
import com.canoo.dolphin.mapping.DolphinBean;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Steppo
 */
@DolphinBean
public class MasterModel {
    
    private ObservableList<MenuItemEntry> menuItems;

    public ObservableList<MenuItemEntry> getMenuItems() {
        return menuItems;
    }
    
    private StackPane stackPaneContent;

    /**
     * @return the stackPaneContent
     */
    public StackPane getStackPaneContent() {
        return stackPaneContent;
    }

    /**
     * @param stackPaneContent the stackPaneContent to set
     */
    public void setStackPaneContent(StackPane stackPaneContent) {
        this.stackPaneContent = stackPaneContent;
    }
}
