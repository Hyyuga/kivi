/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.client.app;

import com.canoo.dolphin.client.ClientConfiguration;
import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.ClientContextFactory;
import com.canoo.dolphin.client.javafx.JavaFXConfiguration;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sn.kivi.client.viewbinder.MainFrameViewBinder;

/**
 *
 * @author Steppo
 */
public class Startup extends Application {

    private static ClientContext clientContext;
    
    private MainFrameViewBinder viewController;

    @Override
    public void init() throws Exception {
        ClientConfiguration config = new JavaFXConfiguration("http://localhost:8080/todo-app/dolphin");
        clientContext = ClientContextFactory.connect(config).get();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Startup.class.getResource("/sn/kivi/resources/view/MainFrame.fxml"));
        viewController = new MainFrameViewBinder(clientContext);
        loader.setController(viewController);

        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        CompletableFuture<ClientContext> connectionPromise = ClientContextFactory.connect(new JavaFXConfiguration("http://localhost:8080/todo-app/dolphin"));
//        connectionPromise.thenAccept(context -> {
//            try {
//                clientContext = context;
//                FXMLLoader loader = new FXMLLoader(Startup.class.getResource("/sn/kivi/resources/view/MainFrame.fxml"));
//                viewController = new MainFrameViewBinder(context);
//                loader.setController(viewController);
//                
//                Scene scene = new Scene(loader.load());
//                primaryStage.setScene(scene);
//                primaryStage.show();
//            } catch (IOException ex) {
//                Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        });
//    }
    
    public static ClientContext getClientContext() {
        return clientContext;
    }

//    @Override
//    public void stop() throws Exception {
//        super.stop();
//        if(viewController != null) {
//            viewController.destroy().get();
//        }
//        if(clientContext != null) {
//            clientContext.disconnect().get();
//        }
//    }
    
    public static void main(String... args) {
        launch(args);
    }
}
