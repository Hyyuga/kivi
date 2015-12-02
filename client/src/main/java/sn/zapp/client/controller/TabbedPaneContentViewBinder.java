/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.client.controller;

import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.javafx.AbstractViewBinder;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import sn.kivi.client.navigation.ContentNavigation;
import sn.zapp.client.app.Zapp;
import sn.zappi.common.model.MenuItemEntry;
import sn.zappi.common.model.TabbedPaneContentModel;

/**
 *
 * @author Steppo
 */
public class TabbedPaneContentViewBinder extends AbstractViewBinder<TabbedPaneContentModel> {

    @FXML
    private Tab tabPaneMitgliedDetails;

    @FXML
    private Tab tabPaneMitgliedErgebnisse;

    private MenuItemEntry entry;

    public TabbedPaneContentViewBinder(ClientContext clientContext) {
        super(clientContext, "TabbedPaneContentController");
    }

    @Override
    public void init() {
        try {
            final MenuItemEntry entries = Zapp.getClientContext().getBeanManager().create(MenuItemEntry.class);
            entries.setText("Nyaki");
            URL urlDetails = ContentNavigation.class.getResource("/sn/zapp/resources/views/MitgliederDialog.fxml");
            FXMLLoader loaderDetails = new FXMLLoader(urlDetails);
            loaderDetails.setController(new MitgliederDetailsViewBinder(Zapp.getClientContext(), entries));
            tabPaneMitgliedDetails.setContent(loaderDetails.load());
            URL urlErgebnis = ContentNavigation.class.getResource("/sn/zapp/resources/views/MitgliederErgebnis.fxml");
            FXMLLoader loaderErgebnis = new FXMLLoader(urlErgebnis);
            loaderErgebnis.setController(new MitgliedErgebnisDialogViewBinder(Zapp.getClientContext()));
            tabPaneMitgliedErgebnisse.setContent(loaderErgebnis.load());
//        Pane scene = loader.load();
        } catch (IOException e) {

        }
    }

    /**
     * @return the entry
     */
    public MenuItemEntry getEntry() {
        return entry;
    }

    /**
     * @param entry the entry to set
     */
    public void setEntry(MenuItemEntry entry) {
        this.entry = entry;
    }
}
