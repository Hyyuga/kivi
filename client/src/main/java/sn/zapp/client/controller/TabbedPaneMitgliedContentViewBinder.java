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
public class TabbedPaneMitgliedContentViewBinder extends AbstractViewBinder<TabbedPaneMitgliedContentModel> {

    @FXML
    private Tab tabPaneMitgliedDetails;

    @FXML
    private Tab tabPaneMitgliedErgebnisse;

    public TabbedPaneMitgliedContentViewBinder(ClientContext clientContext) {
        super(clientContext, "TabbedPaneMitgliedContentController");
    }

    @Override
    public void init() {
        try {
            URL urlDetails = ContentNavigation.class.getResource("/sn/zapp/resources/views/MitgliederDialog.fxml");
            FXMLLoader loaderDetails = new FXMLLoader(urlDetails);
            loaderDetails.setController(new MitgliederDetailsViewBinder(Zapp.getClientContext()));
            tabPaneMitgliedDetails.setContent(loaderDetails.load());
            URL urlErgebnis = ContentNavigation.class.getResource("/sn/zapp/resources/views/MitgliederErgebnis.fxml");
            FXMLLoader loaderErgebnis = new FXMLLoader(urlErgebnis);
            loaderErgebnis.setController(new MitgliedErgebnisDialogViewBinder(Zapp.getClientContext()));
            tabPaneMitgliedErgebnisse.setContent(loaderErgebnis.load());
        } catch (IOException e) {

        }
    }

}
