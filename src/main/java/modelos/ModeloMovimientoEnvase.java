package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloMovimientoEnvase extends ModeloPadre {
    ResultSet rs;

    public void insertarMovimiento(MovimientoEnvase me){
        int idMovimiento=me.getIdMovimiento();
        int idEnvase=me.getIdEnvase();
        int cantidad=me.getCantidad();
        String fecha=me.getFecha();
        try {
            String sql="";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
