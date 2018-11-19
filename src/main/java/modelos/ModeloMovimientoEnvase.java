package modelos;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModeloMovimientoEnvase extends ModeloPadre {
    ResultSet rs;

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
        String sql = "SELECT e.NOMBRE,e.TIPO,e.VOLUMEN,e.DESCRIPCION, me.CANTIDAD, me.FECHA\n" +
                "FROM MOVIMIENTOENVASE me\n" +
                "INNER JOIN  ENVASE e ON e.ID=me.ID_ENVASE\n" +
                "WHERE me.CANTIDAD!=0";
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                MovimientoEnvase movimiento = new MovimientoEnvase(
                        rs.getString("nombre") +" "+ rs.getString("tipo") +" "+ rs.getInt("Volumen") +" "+ rs.getString("descripcion"),
                        rs.getInt("cantidad"),
                        rs.getString("fecha")
                );
                movimientosConNombres.add(movimiento);
            }
            statement.close();
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(ModeloMovimientoEnvase.class);
            logger.error(e.getMessage());
        }
        return movimientosConNombres;
    }

}
