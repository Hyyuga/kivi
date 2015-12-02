/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.controller;

import com.canoo.dolphin.event.Subscription;
import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.event.DolphinEventBus;
import com.canoo.dolphin.server.event.Message;
import com.canoo.dolphin.server.event.MessageListener;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import sn.zappi.common.model.MenuItemEntry;

@DolphinController("TabbedPaneContentController")
public class TabbedPaneContentController {
    
    @Inject
    private DolphinEventBus eventBus;
    
    private MenuItemEntry mitglied;
    
    @PostConstruct
    public void init(){
//        Subscription subscribe = eventBus.subscribe("nameEvent", e ->setNachname((MenuItemEntry) e.getData()));
    }

    /**
     * @return the name
     */
    public MenuItemEntry getMitglied() {
        return mitglied;
    }

    /**
     * @param mitglied the name to set
     */
    public void setMitglied(MenuItemEntry mitglied) {
        this.mitglied = mitglied;
    }
    
}
