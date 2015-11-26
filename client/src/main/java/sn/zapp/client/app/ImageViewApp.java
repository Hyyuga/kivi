/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.zapp.client.app;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Steppo
 */
public class ImageViewApp extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        try {
//            stage.setWidth(Screen.getPrimary().getBounds().getWidth());
//            stage.setHeight(Screen.getPrimary().getBounds().getHeight());
//            BorderPane borderPane = new BorderPane();
//            ImageView imageView = new ImageView();
//             URL url = getClass().getResource("/sn/zapp/resources/pictures/lol.JPG"); 
//            Image image = new Image(url.toString());
//            imageView.setImage(image);
//            imageView.setStyle("-fx-background-color: BLACK");
//            imageView.setFitHeight(stage.getHeight());
//            imageView.setPreserveRatio(true);
//            imageView.setSmooth(true);
//            imageView.setCache(true);
//            borderPane.setCenter(imageView);
//            Scene scene = new Scene(borderPane, Color.BLACK);
//            stage.setScene(scene);
//            stage.show();
            URL url = ImageViewApp.class.getResource("/sn/zapp/resources/views/ImageView.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
