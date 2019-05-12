package modelos;

public class Tapa {
    private int id;
    private String nombre;
    private String descripcion;
    private int cantidad;

    public Tapa(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Tapa() {
    }
    
    public Tapa(int id, String nombre,String descripcion){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Tapa(int id, String nombre, String descripcion, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public int getIdTapa() { return this.id; }

    public void setIdTapa(int id) { this.id = id; }
}
