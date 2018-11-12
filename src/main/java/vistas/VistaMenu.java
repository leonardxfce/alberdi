package vistas;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    private Button btnMovimientos;
    private Label titulo;

    public VistaMenu() {
        super();
        btnEnvase = new Button("Cargar Envase");
        btnTapas = new Button("Cargar Tapa");
        btnListadoEnvases=new Button("Ver Listado de Envases");
        btnListadoTapas=new Button("Ver Listado de Tapas");
        btnExportar = new Button("Exportar");
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

    public Button getBtnMovimientos() { return btnMovimientos; }

    public void config() {
        //IDs
        btnEnvase.setId("menu_envase");
        btnTapas.setId("menu_tapa");
        btnExportar.setId("exportar_dato");
        btnListadoEnvases.setId("menu_listarEnvases");
        btnListadoTapas.setId("menu_listarTapas");
        btnCerrarSesion.setId("menu_cerrarSesion");
        btnMovimientos.setId("movimiento");
        //Controles

        contenido.getChildren().addAll(titulo, btnEnvase, btnTapas, btnListadoEnvases, btnListadoTapas, btnMovimientos,btnExportar, btnCerrarSesion);
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(5);
        contenido.setMinSize(200, 200);
    }

}
