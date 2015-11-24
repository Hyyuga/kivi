/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zappi.client.app;

import com.canoo.dolphin.client.ClientConfiguration;
import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.ClientContextFactory;
import com.canoo.dolphin.client.javafx.JavaFXConfiguration;
import java.util.concurrent.CompletableFuture;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sn.kivi.client.navigation.ContentNavigation;
import sn.kivi.client.viewbinder.MainFrameViewBinder;
import sn.zapp.client.controller.MasterViewBinder;

/**
 *
 * @author Steppo
 */
public class Zapp extends Application {

    private static ClientContext clientContext;
    
    private MasterViewBinder viewController;

    @Override
    public void init() throws Exception {
        ClientConfiguration config = new JavaFXConfiguration("http://localhost:8080/todo-app/dolphin");
        clientContext = ClientContextFactory.connect(config).get();
    }

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        FXMLLoader loader = new FXMLLoader(Zapp.class.getResource("/sn/zapp/resources/views/Master.fxml"));
//        viewController = new MasterViewBinder(clientContext);
//        loader.setController(viewController);
////        ContentNavigation.setMainController(viewController);
//        Scene scene = new Scene(loader.load());
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }

    public void start(Stage primaryStage) throws Exception {
        CompletableFuture<ClientContext> connectionPromise = ClientContextFactory.connect(new JavaFXConfiguration("http://localhost:8080/todo-app/dolphin"));
        connectionPromise.thenAccept(context -> {
            clientContext = clientContext;
            viewController = new MasterViewBinder(context);
            ContentNavigation.setMainController(viewController);
            primaryStage.setScene(new Scene(viewController.getSplitPane()));
            primaryStage.show();
        });
    }
    
    public static ClientContext getClientContext() {
        return clientContext;
    }

    public static void main(String... args) {
        launch(args);
    }
}
