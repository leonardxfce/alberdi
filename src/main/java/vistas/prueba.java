package vistas;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class prueba extends VistaPadre{
    public prueba() {
        final DatePicker datePicker = new DatePicker();
        datePicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String date = datePicker.getValue().format(formatter);
                System.err.println("Selected date: " + date);
            }
        });
        contenido.getChildren().addAll(datePicker);
    }
}
