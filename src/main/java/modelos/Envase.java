/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author caro_
 */
public class Envase {
    
    private int id;
    private String nombre;
    private String tipo;
    private int volumen;
    private String descripcion;

    public Envase(String nombre, String tipo, int volumen, String descripcion) {
        //this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.volumen = volumen;
        this.descripcion = descripcion;
    }

    
    public Envase(){
        this.id = 1;
        this.nombre = "frasco";
        this.tipo = "amanecer";
        this.volumen = 250;
        this.descripcion = "vidrio";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
