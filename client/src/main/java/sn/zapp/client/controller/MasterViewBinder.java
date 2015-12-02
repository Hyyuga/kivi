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
import com.canoo.dolphin.impl.Converters;
import com.canoo.dolphin.impl.PropertyImpl;
import com.canoo.dolphin.impl.info.ClassPropertyInfo;
import com.canoo.dolphin.mapping.Property;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.opendolphin.core.Attribute;
import org.opendolphin.core.client.ClientAttribute;
import sn.kivi.client.navigation.ContentNavigation;
import sn.zappi.common.model.MasterModel;
import sn.zappi.common.model.MenuItemEntry;

/**
 *
 * @author Steppo
 */
public class MasterViewBinder extends AbstractViewBinder<MasterModel> {

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

    public void openMitgliederTabs() {
        ContentNavigation.loadTabContents("/sn/zapp/resources/views/TabbedPane.fxml");
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

    @Override
    protected void init() {
        ObservableList<MenuItemEntry> list = FXWrapper.wrapList(getModel().getMenuItems());
        getListViewMenu().setItems(list);
        listViewMenu.setOnMouseClicked((MouseEvent event) -> {
            ListView<MenuItemEntry> o = (ListView<MenuItemEntry>) event.getSource();
            MenuItemEntry item = o.getSelectionModel().getSelectedItem();
            int row = o.getSelectionModel().getSelectedIndex();
//            FXBinder.bind(item.getTextProperty()).bidirectionalTo(getModel().getSelectedEntry().getTextProperty());
            //CONTROLLER_ACTION_CALL_ERROR_BEAN error
//            invoke("clicked", new Param("item", item));
            invoke("clickedNameEntry", new Param("name", item));
//            FXBinder.bind(item.getTextProperty()).bidirectionalTo(getModel().getName());
            openMitgliederTabs();
        });
        
    }
}