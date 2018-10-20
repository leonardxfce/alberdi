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
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author caro_
 */
public class ModeloEnvase {

    Connection connection;
    Statement statement;
    String url = "jdbc:sqlite:sample.db";

    public ModeloEnvase() {

        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
    }

    public boolean repetido(Envase miAl) {
        String nombre = miAl.getNombre();
        String tipo = miAl.getTipo();
        int volumen = miAl.getVolumen();
        String descripcion = miAl.getDescripcion();
        boolean bandera = false;
        try {
            String SQL = ""
                    + "SELECT COUNT(*) as contar  FROM "
                    + "ENVASE WHERE "
                    + " NOMBRE='" + nombre
                    + "' AND TIPO = '" + tipo
                    + "' AND VOLUMEN =" + volumen
                    + " AND DESCRIPCION = '" + descripcion + "';";
            ResultSet rs = statement.executeQuery(SQL);
            rs.next();
            int cuenta = rs.getInt("contar");
            bandera = cuenta >= 1;
            statement.close();
        } catch (Exception e) {

            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
        return bandera;
    }

    public void guardarEnvaseNuevo(Envase miAl) {
        try {
            statement.executeUpdate("insert into ENVASE values(NULL,'"
                    + miAl.getNombre() + "', '"
                    + miAl.getTipo() + "',"
                    + miAl.getVolumen() + ",'"
                    + miAl.getDescripcion() + "');");
            statement.close();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
    }

    public ArrayList<Envase> darTodosLosEnvases() {
        ArrayList<Envase> misEnvases = new ArrayList<>();
        String SQL = "SELECT * FROM ENVASE;";
        try{
            ResultSet rs = statement.executeQuery(SQL);
            rs.next();
            while(rs.next()){
                Envase envase = new Envase(rs.getString("nombre"),rs.getString("tipo"),rs.getInt("Volumen"),rs.getString("descripcion"));
                misEnvases.add(envase);
            }
            statement.close();
        }catch(Exception e){
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
        return misEnvases;
    }

}
