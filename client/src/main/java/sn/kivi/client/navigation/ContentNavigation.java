/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.client.navigation;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import sn.kivi.client.util.ViewState;
import sn.zapp.client.controller.MasterViewBinder;
import sn.zapp.client.app.Zapp;
import sn.zapp.client.controller.GesamtErgebnisViewBinder;
import sn.zapp.client.controller.MitgliedErgebnisDialogViewBinder;
import sn.zapp.client.controller.MitgliederDetailsViewBinder;
import sn.zapp.client.controller.TabbedPaneMitgliedContentViewBinder;

/**
 *
 * @author y9052
 */
public class ContentNavigation {
    /**
     * Convenience constants for fxml layouts managed by the navigator.
     */
    public static final String MAIN    = "main.fxml";
    public static final String VISTA_1 = "vista1.fxml";
    public static final String VISTA_2 = "vista2.fxml";

    /** The main application layout controller. */
    private static MasterViewBinder mainController;

    /**
     * Stores the main controller for later use in navigation tasks.
     *
     * @param mainController the main application layout controller.
     */
     public static void setMainController(MasterViewBinder mainController) {
        ContentNavigation.mainController = mainController;
    }

    /**
     * Loads the vista specified by the fxml file into the
     * vistaHolder pane of the main application layout.
     *
     * Previously loaded vista for the same fxml file are not cached.
     * The fxml is loaded anew and a new vista node hierarchy generated
     * every time this method is invoked.
     *
     * A more sophisticated load function could potentially add some
     * enhancements or optimizations, for example:
     *   cache FXMLLoaders
     *   cache loaded vista nodes, so they can be recalled or reused
     *   allow a user to specify vista node reuse or new creation
     *   allow back and forward history like a browser
     *
     * @param fxml the fxml file to be loaded.
     */
    public static void loadContent(String fxml, boolean gesamt, ViewState state) {
        try {
            URL url = ContentNavigation.class.getResource(fxml); 
            FXMLLoader loader = new FXMLLoader(url);
            if(gesamt)
                loader.setController(new GesamtErgebnisViewBinder(Zapp.getClientContext()));
            else if(state == ViewState.Member)
                loader.setController(new MitgliederDetailsViewBinder(Zapp.getClientContext(), state));
            else if(state == ViewState.Result)
                loader.setController(new MitgliedErgebnisDialogViewBinder(Zapp.getClientContext()));
            Pane scene = loader.load();
            mainController.setContent(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
