/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.serverspring.basis.controller;

import com.canoo.dolphin.server.DolphinAction;
import com.canoo.dolphin.server.DolphinController;
import com.canoo.dolphin.server.DolphinModel;
import javax.annotation.PostConstruct;
import sn.kivi.common.basis.model.SuchenDialogModel;

/**
 *
 * @author y9052
 */
@DolphinController("SuchenDialogController")
public class SuchenDialogController {
    @DolphinModel
    private SuchenDialogModel model;
    
    @PostConstruct
    public void init(){
        
    }
    
    @DolphinAction
    public void reset(){
        model.setKassenzeichen("Resetted");
    }
    
}
