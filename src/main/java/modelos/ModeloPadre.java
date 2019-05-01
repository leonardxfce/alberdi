/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * @author SantiagoGuirado
 */
public class ModeloPadre {
    //Atributos
    Connection connection;
    Statement statement;
    String url = "jdbc:sqlite:sample.db";
    private String query;

    //Constructor
    public ModeloPadre() {
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
    }

    //Setters && Getters
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
