/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.common.model;

import com.canoo.dolphin.mapping.DolphinBean;
import com.canoo.dolphin.mapping.Property;

/**
 *
 * @author y9052
 */
@DolphinBean
public class MainFrameModel {
    
    private Property<String> txtFieldServer;
    
    public Property<String> txtFieldServerProperty(){
        return txtFieldServer;
    }
    
    public void setTextField(String argValue){
        txtFieldServerProperty().set(argValue);
    }
    
    
}
