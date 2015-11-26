/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.client.controller;

import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.Param;
import com.canoo.dolphin.client.javafx.AbstractViewBinder;
import com.canoo.dolphin.client.javafx.FXBinder;
import com.canoo.dolphin.client.javafx.FXWrapper;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import sn.kivi.client.navigation.ContentNavigation;
import sn.zappi.common.model.MasterModel;
import sn.zappi.common.model.MenuItemEntry;

/**
 *
 * @author Steppo
 */
public class MasterViewBinder extends AbstractViewBinder<MasterModel> {

//    @FXML
//    private TreeView<String> treeViewMenu;
    @FXML
    private SplitPane splitPaneMaster;

    @FXML
    private StackPane stackPaneContent;

    @FXML
    private ListView<MenuItemEntry> listViewMenu;

    public MasterViewBinder(ClientContext clientContext) {
        super(clientContext, "MasterController");
    }

    public void setContent(Pane node) {
        stackPaneContent.getChildren().setAll(node);
    }

    public SplitPane getSplitPane() {
        return splitPaneMaster;
    }

    public void setSplitPane(SplitPane pane) {
        this.splitPaneMaster = pane;
    }

    public void openFallSuchen() {
        ContentNavigation.loadContent("/sn/zapp/resources/views/MitgliederDialog.fxml");
    }

    @Override
    protected void init() {
        ObservableList<MenuItemEntry> list = FXWrapper.wrapList(getModel().getMenuItems());
        listViewMenu.setOnMouseClicked((MouseEvent event) -> {
            ListView<MenuItemEntry> o = (ListView<MenuItemEntry>) event.getSource();
            MenuItemEntry item = o.getSelectionModel().getSelectedItem();
//            int row = o.getSelectionModel().getSelectedIndex();
//            String s = item.getText();
//            Param clicked = new Param("clicked", item.getText());
            Param clicked = new Param("name", item.getText());
            invoke("clicked",clicked);//, new Param("row", row));
            openFallSuchen();
            
//            FXBinder.bind(getModel().getMenuItems().
//                    get(listViewMenu.getSelectionModel().getSelectedIndex()).getTextProperty()).bidirectionalTo(StringProperty(item.getTextProperty()));
//                CompletableFuture<Void> vosdid = invoke("clicked", param1);
//            invoke("clicked");
//                invoke("clicked", new MenuItem[]{item});
        });
//        for (MenuItem  menuItemView : listViewMenu.getItems()) {
//            for (MenuItem menuItemModel : list) {
//                if(menuItemModel.equals(menuItemView)){
////                    FXBinder.bind(menuItemView).bidirectionalTo(menuItemModel.getTextProperty());
//                }
//            }
//             
//        }

        getListViewMenu().setItems(list);

    }

    /**
     * @return the listViewMenu
     */
    public ListView<MenuItemEntry> getListViewMenu() {
        return listViewMenu;
    }

    /**
     * @param listViewMenu the listViewMenu to set
     */
    public void setListViewMenu(ListView<MenuItemEntry> listViewMenu) {
        this.listViewMenu = listViewMenu;
    }

}
//  listViewMenu.setOnMouseClicked((MouseEvent event) -> {
//            ListView<MenuItem> o = (ListView<MenuItem>) event.getSource();
//            MenuItem item = o.getSelectionModel().getSelectedItem();
//            String s = item.getText();
//                invoke("clicked");
//        });
