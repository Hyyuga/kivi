/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.client.calculator.app;

import com.canoo.dolphin.client.ClientConfiguration;
import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.ClientContextFactory;
import com.canoo.dolphin.client.javafx.JavaFXConfiguration;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sn.kivi.client.calculator.controller.CalculatorViewBinder;

/**
 *
 * @author Steppo
 */
public class CalculatorClient  extends Application{
    
    private ClientContext clientContext;

    @Override
    public void init() throws Exception {
        ClientConfiguration config = new JavaFXConfiguration("http://localhost:8080/todo-app/dolphin");
        clientContext = ClientContextFactory.connect(config).get();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = CalculatorClient.class.getResource("/sn/kivi/resources/calculator/view/view.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(new CalculatorViewBinder(clientContext));
        
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String... args) {
        launch(args);
    }
    
    
}
