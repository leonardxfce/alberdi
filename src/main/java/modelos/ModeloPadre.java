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
import principal.ManejadorProperties;

/**
 *
 * @author SantiagoGuirado
 */
public class ModeloPadre {

    Connection connection;
    Statement statement;
    String url  ;

    public  ModeloPadre() {
        try {
            ManejadorProperties propiedades = new ManejadorProperties(1);
            url = propiedades.leerPropiedad("url");
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
    }

}
