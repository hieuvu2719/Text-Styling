/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * HIEU VU
 * PROG24178 1211_34755
 * Assignment4: Javafx designs that allow a user to experiment with text and font settings in a label
 */
package assignment4;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author vuhieu
 */
public class Assignment4Controller implements Initializable {

    @FXML
    private ComboBox<String> foreground, background;

    @FXML
    private RadioButton small, medium, large, left, center, right;

    @FXML
    private Label result;

    @FXML
    private TextField text;

    @FXML
    private Button reset, exit;

    @FXML
    private CheckBox bold, italic;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //default setting
        result.getStyleClass().add("result_label");
        medium.setSelected(true);
        center.setSelected(true);
        result.setAlignment(Pos.CENTER);
        result.getStyleClass().add("grey");
        result.setTextFill(Color.BLACK);
        foreground.getSelectionModel().select("Black");
        background.getSelectionModel().select("Grey");
        
        //exit button event
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        //textfield event
        text.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if (event.getCode().equals(KeyCode.ENTER)) {
                    result.setText(text.getText());
                    text.setText("");
                }
            }
        });

        //small radiobutton event
        small.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                result.getStyleClass().removeAll("medium", "large");
                result.getStyleClass().add("small");

            }

        });

        //medium radiobutton event
        medium.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                result.getStyleClass().removeAll("small", "large");

                result.getStyleClass().add("medium");
            }

        });

        //large radiobutton event
        large.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result.getStyleClass().removeAll("small", "medium");

                result.getStyleClass().add("large");
            }

        });

        //left radio button event
        left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                result.setAlignment(Pos.CENTER_LEFT);
            }

        });

        //center radio button event
        center.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result.setAlignment(Pos.CENTER);

            }

        });

        //right radiobutton event
        right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result.setAlignment(Pos.CENTER_RIGHT);
            }

        });

        //bold checkbox event
        bold.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                result.getStyleClass().add("bold");
            } else {
                result.getStyleClass().remove("bold");

            }
        });

        //italic checkbox event
        italic.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                result.getStyleClass().add("italic");
            } else {
                result.getStyleClass().remove("italic");

            }
        });

        //create observable list for foreground
        String[] color1 = {"Black", "Dark Green", "Brown"};
        ObservableList fore = FXCollections.observableArrayList(color1);

        //create observable list for background
        String[] color2 = {"Grey", "Wheat", "White"};
        ObservableList back = FXCollections.observableArrayList(color2);

        //set item in comboboxes
        foreground.setItems(fore);
        background.setItems(back);

        //foreground combobox event
        foreground.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String color = foreground.getSelectionModel().getSelectedItem();
                if (color.equals("Black")) {
                    result.setTextFill(Color.BLACK);
                }
                if (color.equals("Dark Green")) {
                    result.setTextFill(Color.DARKGREEN);
                }
                if (color.equals("Brown")) {
                    result.setTextFill(Color.BROWN);
                }
                if (Objects.isNull(color)) {
                    result.setTextFill(Color.BLACK);
                }
            }
        });

        //background combobox event
        background.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String color = background.getSelectionModel().getSelectedItem();
                if (color.equals("Grey")) {
                    result.getStyleClass().removeAll("wheat", "white");
                    result.getStyleClass().add("grey");
                }
                if (color.equals("Wheat")) {
                    result.getStyleClass().removeAll("grey", "white");
                    result.getStyleClass().add("wheat");
                }
                if (color.equals("White")) {
                    result.getStyleClass().removeAll("wheat", "grey");
                    result.getStyleClass().add("white");
                }

            }
        });

        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                result.getStyleClass().removeAll("small", "medium", "large", "bold", "italic", "grey", "wheat", "white");
                result.getStyleClass().add("grey");
                result.setTextFill(Color.BLACK);
                result.setAlignment(Pos.CENTER);
                result.setText("Assignment 4");
                text.setText("");
                bold.setSelected(false);
                italic.setSelected(false);
                small.setSelected(false);
                medium.setSelected(true);
                large.setSelected(false);
                left.setSelected(false);
                center.setSelected(true);
                right.setSelected(false);
                foreground.getSelectionModel().select("Black");
                background.getSelectionModel().select("Grey");
                


            }
        });
    }
}
