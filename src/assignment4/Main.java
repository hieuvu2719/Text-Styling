/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * HIEU VU
 * PROG24178 1211_34755
 * Assignment4: Javafx designs that allow a user to experiment with text and font settings in a label
 */
package assignment4;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author vuhieu
 */
public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Assignment4.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("Assignment4.css").toExternalForm());
        stage.setTitle("Assignment4");
        stage.setScene(scene);
        stage.show();
    }

}
