/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelos.Tapa;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SantiagoGuirado
 */
public class ModeloTapa {

    Connection connection;
    Statement statement;
    ResultSet rs;
    private String url;

    //constructores
    public ModeloTapa() {
        this.url = "jdbc:sqlite:sample.db";
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //select, credios a quien corresponda.
    public List darTodosLosEnvases() {
        ArrayList<Tapa> misTapas = new ArrayList<>();
        String sql = "SELECT * FROM TAPA;";
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                Tapa tapa = new Tapa(rs.getString("nombre"), rs.getString("descripcion"));
                misTapas.add(tapa);
            }
        } catch (Exception e) {
            org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
            System.out.println(e.getMessage());
        }
        return misTapas;
    }

    //insert
    public void insert(Tapa tapa) {
        String nombre = tapa.getNombre();
        String descripcion = tapa.getDescripcion();
        try {
            statement.executeUpdate("INSERT INTO TAPA (ID, NOMBRE, DESCRIPCION) VALUES (" + null + ", '"
                    + nombre + "', '" + descripcion + "');");
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean repetido(Tapa tapa) {
        String nombre = tapa.getNombre();
        String descripcion = tapa.getDescripcion();
        boolean bandera = false;
        try {
            String SQL = ""
                    + "SELECT COUNT(*) as contar  FROM "
                    + "TAPA WHERE "
                    + " NOMBRE='" + nombre
                    + "' AND DESCRIPCION = '" + descripcion + "';";
            ResultSet rs = statement.executeQuery(SQL);
            rs.next();
            int cuenta = rs.getInt("contar");
            if (cuenta >= 1) {
                bandera = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return bandera;
    }

    //setters && getters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
