package modelos;

public class Tapa {
    private int idTapa;
    private String nombre;
    private String descripcion;

    public Tapa(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdTapa() { return this.idTapa; }

    public void setIdTapa(int idTapa) { this.idTapa = idTapa; }
}
