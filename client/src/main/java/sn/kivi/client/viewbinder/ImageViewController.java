/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.kivi.client.viewbinder;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Steppo
 */
public class ImageViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = new Image(getClass().getResource("/sn/zapp/resources/pictures/lol.JPG").toString());
        imageView.setImage(image);
    }

}
