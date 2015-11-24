/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.client.controller;

import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.javafx.AbstractViewBinder;
import com.canoo.dolphin.client.javafx.FXWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import sn.kivi.client.navigation.ContentNavigation;
import sn.zappi.common.model.MasterModel;
import sn.zappi.common.model.MenuItem;

/**
 *
 * @author Steppo
 */
public class MasterViewBinder extends AbstractViewBinder<MasterModel> {

//    @FXML
//    private TreeView<String> treeViewMenu;
    @FXML
    private final SplitPane splitPaneMaster;

    @FXML
    private final StackPane stackPaneContent;

    @FXML
    private final ListView<MenuItem> listViewMenu;

    public MasterViewBinder(ClientContext clientContext) {
        super(clientContext, "MasterController");
        listViewMenu = new ListView<>();
        splitPaneMaster = new SplitPane();
        splitPaneMaster.getItems().add(listViewMenu);
        stackPaneContent = new StackPane();
        splitPaneMaster.getItems().add(stackPaneContent);
    }

    public void setContent(Pane node) {
        stackPaneContent.getChildren().setAll(node);
    }

    public SplitPane getSplitPane() {
        return splitPaneMaster;
    }
    
    public void openFallSuchen(){
        ContentNavigation.loadContent("/sn/kivi/resources/basis/view/SuchenDialog.fxml");
    }

    @Override
    protected void init() {
        ObservableList<MenuItem> list = FXWrapper.wrapList(getModel().getMenuItems());
//        listViewMenu.setOnMouseClicked(event -> invoke("clicked"));
//        listViewMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                openFallSuchen();
//            }
//        });
        listViewMenu.setItems(list);

    }

}
