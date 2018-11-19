package modelos;

public class MovimientoEnvase {
    private int idMovimiento;
    private int idEnvase;
    private int cantidad;
    private String fecha;

    private String nombre;//he añadido este atributo para poder mostrar un correcto nombre sobre una de las columnas de las tableView..no se ha ocurrido una mejor idea todavia :V @Lisa

    public MovimientoEnvase(int idMovimiento, int idEnvase, int cantidad, String fecha) {
        this.idMovimiento = idMovimiento;
        this.idEnvase = idEnvase;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    public MovimientoEnvase(int idEnvase, int cantidad, String fecha) {
        this.idEnvase = idEnvase;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    public MovimientoEnvase(){ }

    public MovimientoEnvase(String nombre, int cantidad, String fecha){
        this.nombre=nombre;
        this.cantidad=cantidad;
        this.fecha=fecha;
    }

    public int getIdMovimiento() {
        return this.idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public int getIdEnvase() {
        return this.idEnvase;
    }

    public void setIdEnvase(int idEnvase) {
        this.idEnvase = idEnvase;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombreDelEnvase(String nombreDelEnvase) {
        this.nombre = nombreDelEnvase;
    }
}
