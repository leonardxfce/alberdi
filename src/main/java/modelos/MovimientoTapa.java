package modelos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templatesm
 * and open the template in the editor.
 */

/**
 *
 * @author caro_
 */
public class MovimientoTapa {
    private int idMovimientoTapa;
    private int idTapa;
    private int cantidad;
    private String fecha;
    private String nombre;
    
    public MovimientoTapa(int idMovimientoTapa, int idTapa, int cantidad, String fecha) {
        this.idMovimientoTapa = idMovimientoTapa;
        this.idTapa = idTapa;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    public MovimientoTapa(int idTapa, int cantidad, String fecha) {
        this.idTapa = idTapa;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    public MovimientoTapa(){ }
    public MovimientoTapa(String nombre, int cantidad, String fecha){
        this.nombre=nombre;
        this.cantidad=cantidad;
        this.fecha=fecha;
    }

    public int getIdMovimientoTapa() {
        return idMovimientoTapa;
    }

    public void setIdMovimientoTapa(int idMovimientoTapa) {
        this.idMovimientoTapa = idMovimientoTapa;
    }

    public int getIdTapa() {
        return idTapa;
    }

    public void setIdTapa(int idTapa) {
        this.idTapa = idTapa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombreDeLaTapa(String nombreDeLaTapa) {
        this.nombre = nombreDeLaTapa;
    }
    
}
