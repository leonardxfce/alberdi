/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.ResultSet;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SantiagoGuirado
 */
public class ModeloTapa extends ModeloPadre {

    public ModeloTapa() {
        super();
    }

    //insert
    public void insert(Tapa tapa) {
        String nombre = tapa.getNombre();
        String descripcion = tapa.getDescripcion();
        setQuery("INSERT INTO TAPA (ID, NOMBRE, DESCRIPCION) VALUES (NULL, '" + nombre + "', '" + descripcion + "');");
        try {
            statement.executeUpdate(getQuery());
            String sql2 = ""
                    + "SELECT ID FROM "
                    + "TAPA WHERE "
                    + " NOMBRE='" + nombre
                    + "' AND DESCRIPCION = '" + descripcion + "';";
            int id;
            try (ResultSet resultado = statement.executeQuery(sql2)) {
                resultado.next();
                id = resultado.getInt("ID");
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String fecha = LocalDate.now().format(formatter);
            statement.executeUpdate(
                "INSERT INTO MOVIMIENTOTAPA VALUES ( NULL," + id + ", 0 , '" + fecha + "' );"
            );
            statement.close();
        } catch (SQLException ex) {
            Logger logger = Logger.getLogger(ModeloTapa.class);
            logger.error(ex.getMessage());
        }
    }

    public boolean repetido(Tapa tapa) {
        String nombre = tapa.getNombre();
        String descripcion = tapa.getDescripcion();
        boolean bandera = false;
        try {
            setQuery("SELECT COUNT(*) as contar  FROM "
                    + "TAPA WHERE "
                    + " NOMBRE='" + nombre
                    + "' AND DESCRIPCION = '" + descripcion + "';");
            setResultSet(statement.executeQuery(getQuery()));
            getResultSet().next();
            int cuenta = getResultSet().getInt("contar");
            if (cuenta >= 1) {
                bandera = true;
            }
            statement.close();
            getResultSet().close();
        } catch (SQLException ex) {
            Logger logger = Logger.getLogger(ModeloTapa.class);
            logger.error(ex.getMessage());
        }
        return bandera;
    }

    public void modificarTapa(Tapa miAl) {
        int id = miAl.getIdTapa();
        String nombre = miAl.getNombre();
        String descripcion = miAl.getDescripcion();
        setQuery("UPDATE TAPA SET "
                + " NOMBRE='" + nombre
                + "',DESCRIPCION = '" + descripcion + "' WHERE ID= " + id + ";");
        try {
            statement.executeUpdate(getQuery());
            statement.close();
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(ModeloTapa.class);
            logger.error(e.getMessage());
        }
    }

    //select de todos los datos, copiado a modeloEnvase(creditos a quien corresponda )
    public List darTodasLasTapas() {
        ArrayList<Tapa> misTapas = new ArrayList<>();
        setQuery("SELECT t.*, SUM(mt.CANTIDAD) stock FROM MOVIMIENTOTAPA mt INNER JOIN  TAPA t ON t.ID= mt.ID_TAPA GROUP BY t.ID");
        
        try (ResultSet rss = statement.executeQuery(getQuery())) {
            while (rss.next()) {
                Tapa tapa;
                tapa = new Tapa(
                    rss.getInt("id"),
                    rss.getString("nombre"),
                    rss.getString("descripcion"),
                    rss.getInt("stock")
                );
                misTapas.add(tapa);
            }
            statement.close();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloTapa.class);
            logger.error(e.getMessage());
        }
        return misTapas;
    }

    public Tapa darUno(int id) {
        Tapa tapa = null;
        setQuery("SELECT * FROM TAPA WHERE ID= " + id + ";");
        try {
            setResultSet(statement.executeQuery(getQuery()));
            getResultSet().next();
            tapa = new Tapa(getResultSet().getInt("id"),
                    getResultSet().getString("nombre"), getResultSet().getString("descripcion"));
            statement.close();
            getResultSet().close();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
        return tapa;
    }
}
