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
public class VentanaPopUp {
    
    public static void display(String dato) {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Mensaje");
        Label label1 = new Label(dato);
        Button bntOk = new Button("OK");
        
        bntOk.setOnAction(e -> {
            popup.close();
        }
        );

        HBox HLayout1 = new HBox(20);
        HBox HLayout2 = new HBox(20);
        VBox VLayout1 = new VBox(10);
        
        HLayout1.getChildren().addAll(label1);
        HLayout1.setAlignment(Pos.CENTER);
        
        HLayout2.getChildren().addAll(bntOk);
        HLayout2.setAlignment(Pos.CENTER);
        
        VLayout1.getChildren().addAll(HLayout1, HLayout2);
        VLayout1.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(VLayout1);
        popup.setScene(scene);
        popup.showAndWait();
    }
    
}
