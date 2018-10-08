package modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModeoTapa {
    Connection connection;
    Statement statement;
    ResultSet rs;

    String nombre ;
    String descripcion;

    public ModeloTapa(String nombre, String tipo, String material, int capacidad) {
        this.nombre = nombre;
        this.descripcion= descripcion;
        this.material = material;
        this.capacidad = capacidad;
        this.url = "jdbc:sqlite:sample.db";

    }
}
