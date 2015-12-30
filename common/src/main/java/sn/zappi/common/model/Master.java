/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zappi.common.model;

import com.canoo.dolphin.collections.ObservableList;
import com.canoo.dolphin.mapping.DolphinBean;
import com.canoo.dolphin.mapping.Property;

/**
 *
 * @author Steppo
 */
@DolphinBean
public class Master {

    private ObservableList<String> menuItems;

    public ObservableList<String> getMenuItems() {
        return menuItems;
    }
    
    //entry eigenes menu object machen mit mehr attributen
    private Property<String> selectedEntry;
    

    public Property<String> selectedEntry() {
        return selectedEntry;
    }

    public void setSelectedEntry(String selectedEntry) {
        selectedEntry().set(selectedEntry);
    }

    public String getSelectedEntry() {
        return selectedEntry().get();
    }

}
