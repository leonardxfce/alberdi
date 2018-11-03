/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author SantiagoGuirado
 */
public class VentanaPopUp extends VistaPadre {
    
    public void display(String dato) {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Mensaje");
        Label label1 = new Label(dato);
        Button bntOk = new Button("OK");
        
        bntOk.setOnAction(e -> popup.close());

        HBox hBox = new HBox(20);
        HBox hBox1 = new HBox(20);
        VBox vBox = new VBox(10);
        
        hBox.getChildren().addAll(label1);
        hBox.setAlignment(Pos.CENTER);
        
        hBox1.getChildren().addAll(bntOk);
        hBox1.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(hBox, hBox1);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5);
        vBox.setMinSize(200, 100);
        vBox.setPadding(margenes);
        
        Scene scene = new Scene(vBox);
        popup.setScene(scene);
        popup.setResizable(false);
        popup.showAndWait();
    }
    
}
