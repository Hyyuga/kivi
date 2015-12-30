/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.client.controller;

import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.javafx.AbstractViewBinder;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import sn.kivi.client.navigation.ContentNavigation;
import sn.kivi.client.util.ViewState;
import sn.zappi.common.model.Master;

/**
 *
 * @author Steppo
 */
public class MasterViewBinder extends AbstractViewBinder<Master> {

    @FXML
    private StackPane stackPaneContent;

    @FXML
    private Menu menuMember;

    @FXML
    private Menu menuResult;

    @FXML
    private MenuItem menuItemCreateMitglied;

    @FXML
    private MenuItem menuItemCreateSpieltag;

    @FXML
    private Menu menuCreate;

    private ViewState viewState = null;

    public MasterViewBinder(ClientContext clientContext) {
        super(clientContext, "MasterController");
    }

    public void setContent(Pane node) {
        stackPaneContent.getChildren().setAll(node);
    }

    public void manageContentCreation(boolean gesamt, ViewState state) {
        if (gesamt) {
            ContentNavigation.loadContent("/sn/zapp/resources/views/GesamtErgebnis.fxml", gesamt, state);
        } else if (state == ViewState.Member) {
            ContentNavigation.loadContent("/sn/zapp/resources/views/MitgliederDetails.fxml", gesamt, state);
        } else {
            ContentNavigation.loadContent("/sn/zapp/resources/views/MitgliederErgebnis.fxml", gesamt, state);
        }
    }

    @Override
    protected void init() {
        createViewMenu();
        initCreateMenu();
    }

    private void createViewMenu() {
        for (String menuItem : getModel().getMenuItems()) {
            menuResult.getItems().add(createViewMenuItem(menuItem, ViewState.Result));
            if (!menuItem.equalsIgnoreCase("gesamt")) {
                menuMember.getItems().add(createViewMenuItem(menuItem, ViewState.Member));
            }
        }
    }

    private MenuItem createViewMenuItem(String item, ViewState state) {
        MenuItem result = new MenuItem(item);
        result.setOnAction(event -> {

            MenuItem o = (MenuItem) event.getSource();
            String selectedItem = o.getText();
            boolean changeView = (getModel().getSelectedEntry() == null
                    || (getModel().getSelectedEntry().equalsIgnoreCase("gesamt") && !selectedItem.equalsIgnoreCase("gesamt"))
                    || (!getModel().getSelectedEntry().equalsIgnoreCase("gesamt") && selectedItem.equalsIgnoreCase("gesamt"))
                    || viewState == null
                    || viewState != state);

            if (changeView) {
                manageContentCreation(selectedItem.equalsIgnoreCase("gesamt"), state);
            }
            viewState = state;
            getModel().setSelectedEntry(selectedItem);
        });
        return result;
    }

//    private MenuItem createMemberMenuItem(String item, ViewState state) {
//        MenuItem result = new MenuItem(item);
//        result.setOnAction(event -> {
//            MenuItem o = (MenuItem) event.getSource();
//            String selectedItem = o.getText();
//            boolean changeView = (getModel().getSelectedEntry() == null
//                    || (getModel().getSelectedEntry().equalsIgnoreCase("gesamt") && !selectedItem.equalsIgnoreCase("gesamt"))
//                    || (!getModel().getSelectedEntry().equalsIgnoreCase("gesamt") && selectedItem.equalsIgnoreCase("gesamt")));
//
//            if (changeView) {
//                manageContentCreation(selectedItem.equalsIgnoreCase("gesamt"), state);
//            }
//            getModel().setSelectedEntry(selectedItem);
//        });
//        return result;
//    }
    private void initCreateMenu() {
        menuItemCreateMitglied.setOnAction(event -> {

        });

        menuItemCreateSpieltag.setOnAction(event -> {

        });
    }
}
