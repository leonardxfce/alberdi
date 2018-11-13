package vistas;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * @author SantiagoLisa
 */
public class VistaMenu extends VistaPadre {

    private Button btnEnvase;
    private Button btnTapas;
    private Button btnCerrarSesion;
    private Button btnListadoEnvases;
    private Button btnListadoTapas;
    private Button btnExportar;
    private Button btnAjustarFuente;
    private Button btnMovimientos;
    private Label titulo;

    public VistaMenu() {
        super();
        btnEnvase = new Button("Cargar Envase");
        btnTapas = new Button("Cargar Tapa");
        btnListadoEnvases=new Button("Ver Listado de Envases");
        btnListadoTapas=new Button("Ver Listado de Tapas");
        btnExportar = new Button("Exportar");
        btnAjustarFuente = new Button("Ajustar Fuente");
        btnCerrarSesion = new Button("Cerrar Sesion");
        btnMovimientos = new Button("Manejo de Insumos");
        titulo = new Label("-----");
    }


    public Button getBtnEnvase() {
        return btnEnvase;
    }

    public Button getBtnTapas() {
        return btnTapas;
    }

    public Button getBtnExportar() {
        return btnExportar;
    }

    public Button getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    public Button getBtnListadoEnvases() {
        return btnListadoEnvases;
    }

    public Button getBtnListadoTapas() {
        return btnListadoTapas;
    }

    public Button getBtnAjustarFuente() {
        return btnAjustarFuente;
    }

    public void setBtnAjustarFuente(Button btnAjustarFuente) {
        this.btnAjustarFuente = btnAjustarFuente;
    }

    public Button getBtnMovimientos() { return btnMovimientos; }

    public void config() {
        //IDs
        btnEnvase.setId("menu_envase");
        btnTapas.setId("menu_tapa");
        btnExportar.setId("exportar_dato");
        btnListadoEnvases.setId("menu_listarEnvases");
        btnListadoTapas.setId("menu_listarTapas");
        btnAjustarFuente.setId("menu_ajustarFuente");
        btnCerrarSesion.setId("menu_cerrarSesion");
        btnMovimientos.setId("movimiento");
        //Controles
        contenido.getChildren().addAll(titulo, btnEnvase, btnTapas, btnListadoEnvases, btnListadoTapas, btnMovimientos, btnExportar, btnAjustarFuente, btnCerrarSesion);
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(5);
        contenido.setMinSize(200, 200);
    }

    @Override
    public void cambioTamanoFuente(int tamano) {
        Font fuente = new Font("Times New Roman", tamano);
        btnEnvase.setFont(fuente);
        btnTapas.setFont(fuente);
        btnCerrarSesion.setFont(fuente);
        btnListadoEnvases.setFont(fuente);
        btnListadoTapas.setFont(fuente);
        btnAjustarFuente.setFont(fuente);
        btnExportar.setFont(fuente);
        titulo.setFont(fuente);
    }

}
