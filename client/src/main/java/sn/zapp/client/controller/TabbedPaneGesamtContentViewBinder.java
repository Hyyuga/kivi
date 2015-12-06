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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import sn.kivi.client.navigation.ContentNavigation;
import sn.zapp.client.app.Zapp;
import sn.zappi.common.model.TabbedPaneMitgliedContentModel;

/**
 *
 * @author Steppo
 */
public class TabbedPaneGesamtContentViewBinder extends AbstractViewBinder<TabbedPaneMitgliedContentModel> {

    @FXML
    private Tab tabPaneGesamtErgebnisse;

    public TabbedPaneGesamtContentViewBinder(ClientContext clientContext) {
        super(clientContext, "TabbedPaneGesamtContentController");
    }

    @Override
    public void init() {
        try {
            URL urlErgebnis = ContentNavigation.class.getResource("/sn/zapp/resources/views/GesamtErgebnis.fxml");
            FXMLLoader loaderErgebnis = new FXMLLoader(urlErgebnis);
            loaderErgebnis.setController(new GesamtErgebnisViewBinder(Zapp.getClientContext()));
            tabPaneGesamtErgebnisse.setContent(loaderErgebnis.load());
        } catch (IOException e) {

        }
    }

}
