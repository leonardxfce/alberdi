/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SantiagoGuirado
 */
public class ModeloTapa extends ModeloPadre {

    ResultSet rs;

    public ModeloTapa() {
        super();
    }
    //insert
    public void insert(Tapa tapa) {
        String nombre = tapa.getNombre();
        String descripcion = tapa.getDescripcion();
        try {
            statement.executeUpdate("INSERT INTO TAPA (ID, NOMBRE, DESCRIPCION) VALUES (NULL, '"
                    + nombre + "', '" + descripcion + "');");
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
            Logger logger = Logger.getLogger(ModeloTapa.class);
            logger.error(ex.getMessage());
        }
        return bandera;
    }
    
     public void modificarTapa(Tapa miAl) {
        int id = miAl.getIdTapa();
        String nombre = miAl.getNombre();
        String descripcion = miAl.getDescripcion();
        String sql = ""
                + "UPDATE TAPA SET "
                + " NOMBRE='" + nombre
                + "',DESCRIPCION = '" + descripcion + "' WHERE ID= " + id + ";";
        try {
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(ModeloTapa.class);
            logger.error(e.getMessage());
        }
    }
     
    //se agregó este método para mostrar las tapas ingresadas en el combo box 
    public List darTapasCombo(){
        ArrayList<Tapa> tapas = new ArrayList<>();
        String sql = "SELECT * FROM TAPA";
        try(ResultSet resul = statement.executeQuery(sql)){
            while(resul.next()){
                Tapa tapa = new Tapa(
                    resul.getInt("id"),
                    resul.getString("nombre"),
                    resul. getString("descripcion")
                );
               tapas.add(tapa); 
            }
             
        }catch(Exception e){
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
       return tapas;  
    }
     
    //select de todos los datos, copiado a modeloEnvase(creditos a quien corresponda )
    public List darTodasLasTapas() {
        ArrayList<Tapa> misTapas = new ArrayList<>();
        String sql = "SELECT t.*, SUM(mt.CANTIDAD) stock FROM MOVIMIENTOTAPA mt INNER JOIN  TAPA t ON t.ID= mt.ID_TAPA GROUP BY t.ID";
        
        try (ResultSet rss = statement.executeQuery(sql)) {
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
        String sql = "SELECT * FROM TAPA WHERE ID= " + id + ";";
        Tapa tapa = null;
        try (ResultSet rss = statement.executeQuery(sql)) {
            rss.next();
            tapa = new Tapa(rss.getInt("id"), rss.getString("nombre"),rss.getString("descripcion"));
            statement.close();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
        return tapa;
    }
    //setters && getters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
