/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.serverspring.controller;

import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;
import javax.annotation.PostConstruct;
import sn.kivi.common.model.MainFrameModel;

/**
 *
 * @author y9052
 */
@DolphinController("MainFrameController")
public class MainFrameController {
    
    @DolphinModel
    private MainFrameModel model;
    
    @PostConstruct
    public void init(){
        model.setTextField("Nachricht vom Server empfangen");
    }
    
}
