/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zappi.common.model;

import com.canoo.dolphin.collections.ObservableList;
import com.canoo.dolphin.mapping.DolphinBean;
import com.canoo.dolphin.mapping.Property;
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
    private MenuItemEntry selectedEntry;
    
    private Property<String> name;
    
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

    public MenuItemEntry getSelectedEntry(){
        return selectedEntry;
    }
    /**
     * @param selectedEntry the selectedEntry to set
     */
    public void setSelectedEntry(MenuItemEntry selectedEntry) {
        this.selectedEntry = selectedEntry;
    }

    /**
     * @return the name
     */
    public Property<String> getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(Property<String> name) {
        this.name = name;
    }
}
