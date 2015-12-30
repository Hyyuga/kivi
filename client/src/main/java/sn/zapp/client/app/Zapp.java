/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.client.app;

import com.canoo.dolphin.client.ClientConfiguration;
import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.ClientContextFactory;
import com.canoo.dolphin.client.javafx.JavaFXConfiguration;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sn.kivi.client.navigation.ContentNavigation;
import sn.zapp.client.controller.MasterViewBinder;

/**
 *
 * @author Steppo
 */
public class Zapp extends Application {

    private static ClientContext clientContext;
    
    @Override
    public void init() throws Exception {
        ClientConfiguration config = new JavaFXConfiguration("http://localhost:8080/todo-app/dolphin");
        clientContext = ClientContextFactory.connect(config).get();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = Zapp.class.getResource("/sn/zapp/resources/views/Master.fxml"); 
        FXMLLoader loader = new FXMLLoader(url);
        MasterViewBinder viewController = new MasterViewBinder(clientContext);
        loader.setController(viewController);
        ContentNavigation.setMainController(viewController);
        AnchorPane stackPaneMaster = (AnchorPane)loader.load();
//        viewController.setContent(stackPaneMaster);
//        SplitPane splitPaneMaster = (SplitPane)loader.load();
//        viewController.setSplitPane(splitPaneMaster);
        Scene scene = new Scene(stackPaneMaster);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static ClientContext getClientContext() {
        return clientContext;
    }

    public static void main(String... args) {
        launch(args);
    }
}
