/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
        } catch (SQLException ex) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(ex.getMessage());
        }
    }

    //insert
    public void insert(Tapa tapa) {
        String nombre = tapa.getNombre();
        String descripcion = tapa.getDescripcion();
        try {
            statement.executeUpdate("INSERT INTO TAPA (ID, NOMBRE, DESCRIPCION) VALUES (" + null + ", '"
                    + nombre + "', '" + descripcion + "');");
            statement.close();
        } catch (SQLException ex) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(ex.getMessage());
        }
    }

    public boolean repetido(Tapa tapa) {
        String nombre = tapa.getNombre();
        String descripcion = tapa.getDescripcion();
        boolean bandera = false;
        try {
            String sql = ""
                    + "SELECT COUNT(*) as contar  FROM "
                    + "TAPA WHERE "
                    + " NOMBRE='" + nombre
                    + "' AND DESCRIPCION = '" + descripcion + "';";
            rs = statement.executeQuery(sql);

            rs.next();
            int cuenta = rs.getInt("contar");
            if (cuenta >= 1) {
                bandera = true;
            }
            statement.close();
            rs.close();
        } catch (SQLException ex) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(ex.getMessage());
        }
        return bandera;
    }

    //select de todos los datos, copiado a modeloEnvase(creditos a quien corresponda )
    public List darTodasLasTapas() {
        ArrayList<Tapa> listadoTapas = new ArrayList<>();
        try {
            rs = statement.executeQuery("SELECT * FROM TAPA");
            while (rs.next()) {
                Tapa tapa = new Tapa(rs.getString("nombre"), rs.getString("descripcion"));
                listadoTapas.add(tapa);
            }
            statement.close();
            rs.close();
        } catch (SQLException ex) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(ex.getMessage());
        }
        return listadoTapas;
    }


    //setters && getters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
