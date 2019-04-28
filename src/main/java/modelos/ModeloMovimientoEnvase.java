package modelos;

import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class ModeloMovimientoEnvase extends ModeloPadre {

    public void insertarMovimiento(MovimientoEnvase me) {
        int idEnvase = me.getIdEnvase();
        int cantidad = me.getCantidad();
        String fecha = me.getFecha();
        try {
            String sql = "insert into MOVIMIENTOENVASE values(NULL,'"
                    + idEnvase + "',"
                    + cantidad + ",'"
                    + fecha + "');";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(ModeloMovimientoEnvase.class);
            logger.error(e.getMessage());
        }
    }

    public List darTodosLosMovimientosConNombre() {
        ArrayList<MovimientoEnvase> movimientosConNombres = new ArrayList<>();
        setQuery("SELECT e.NOMBRE,e.TIPO,e.VOLUMEN,e.DESCRIPCION, me.CANTIDAD, me.FECHA\n" +
                "FROM MOVIMIENTOENVASE me\n" + "INNER JOIN  ENVASE e ON e.ID=me.ID_ENVASE\n" +
                "WHERE me.CANTIDAD!=0");
        try {
            setResultSet(statement.executeQuery(getQuery()));
            while (getResultSet().next()) {
                MovimientoEnvase movimiento = new MovimientoEnvase(
                        getResultSet().getString("nombre") + " " +
                                getResultSet().getString("tipo") + " " +
                                getResultSet().getInt("Volumen") + " " +
                                getResultSet().getString("descripcion"),
                        getResultSet().getInt("cantidad"),
                        getResultSet().getString("fecha")
                );
                movimientosConNombres.add(movimiento);
            }
            statement.close();
            getResultSet().close();
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(ModeloMovimientoEnvase.class);
            logger.error(e.getMessage());
        }
        return movimientosConNombres;
    }

    //se agregó el método verificarCantStock para evitar el ingreso de cantidades que superar el stock existente a la hora de quitar una cantidad de envases
    public boolean verificarCantStock(int id,int quitar){
        setQuery("SELECT SUM(CANTIDAD) stock FROM MOVIMIENTOENVASE WHERE ID_ENVASE="+id+";");
        boolean respuesta = false;
        try {
            setResultSet(statement.executeQuery(getQuery()));
            if(quitar <= getResultSet().getInt("stock")){
                respuesta = true;
            }else{
                respuesta = false;
            } 
            statement.close();
            getResultSet().close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ModeloMovimientoTapa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;   
        
    }
    
}
