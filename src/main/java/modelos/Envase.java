
package modelos;


public class Envase {

    private int id;
    private String nombre;
    private String tipo;
    private int volumen;
    private String descripcion;
    private int cantidad;

    public Envase(int id, String nombre, String tipo, int volumen, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.volumen = volumen;
        this.descripcion = descripcion;
    }
    
    public Envase(String nombre, String tipo, int volumen, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.volumen = volumen;
        this.descripcion = descripcion;
    }
    
    public Envase() {
        this.id = 1;
        this.nombre = "frasco";
        this.tipo = "amanecer";
        this.volumen = 250;
        this.descripcion = "vidrio";
    }
    public Envase(int id, String nombre, String tipo, int volumen, String descripcion, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.volumen = volumen;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
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
    public int getCantidad() { return this.cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
