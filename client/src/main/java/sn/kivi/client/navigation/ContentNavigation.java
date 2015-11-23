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
import sn.kivi.client.app.Startup;
import sn.kivi.client.basis.viewbinder.SuchenDialogViewBinder;
import sn.zapp.client.controller.MasterViewBinder;
import sn.zappi.client.app.Zapp;

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
//    private static MainFrameViewBinder mainController;
    private static MasterViewBinder mainController;

    /**
     * Stores the main controller for later use in navigation tasks.
     *
     * @param mainController the main application layout controller.
     */
//    public static void setMainController(MainFrameViewBinder mainController) {
//        ContentNavigation.mainController = mainController;
//    }
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
    public static void loadContent(String fxml) {
        try {
            URL url = ContentNavigation.class.getResource(fxml); 
            FXMLLoader loader = new FXMLLoader(url);
            loader.setController(new SuchenDialogViewBinder(Zapp.getClientContext()));
            Pane scene = loader.load();
            mainController.setVista(scene);
            System.err.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
