/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.client.viewbinder;

import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.javafx.AbstractViewBinder;
import com.canoo.dolphin.client.javafx.FXBinder;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import sn.kivi.client.navigation.ContentNavigation;
import sn.kivi.common.model.MainFrameModel;

/**
 *
 * @author y9052
 */
public class MainFrameViewBinder extends AbstractViewBinder<MainFrameModel>{
    
    
    /** Holder of a switchable vista. */
    @FXML
    private StackPane contentHolder;

    @FXML 
    private TextField txtFieldServer;
    
    /**
     * Replaces the vista displayed in the vista holder with a new vista.
     *
     * @param node the vista node to be swapped in.
     */
    public void setVista(Pane node) {
        contentHolder.getChildren().setAll(node);
    }
    
    
    @FXML
    public void openFallSuchen(){
        ContentNavigation.loadContent("/sn/kivi/resources/basis/view/SuchenDialog.fxml");
    }
    
    public MainFrameViewBinder(ClientContext clientContext){
        super(clientContext,"MainFrameController");
        
    }

    @Override
    protected void init() {
        FXBinder.bind(txtFieldServer.textProperty()).bidirectionalTo(getModel().txtFieldServerProperty());
    }
    
}
