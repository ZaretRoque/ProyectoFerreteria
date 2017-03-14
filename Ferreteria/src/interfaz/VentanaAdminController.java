/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import ferreteria.Inventario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zaret
 */
public class VentanaAdminController implements Initializable {

  private Stage principal;

  public void setStagePrincipal(Stage principal) {
    this.principal = principal;
  }

  @FXML
  public TextField tNombre;

  @FXML
  public TextField tDescripcion;

  @FXML
  public TextField tPrecio;

  @FXML
  public TextField tExistencia;

  @FXML
  public TextField tTipo;

  @FXML
  public Button bAgregar;

  @FXML
  public void agregar() {
    String nombre = tNombre.getText();
    System.out.println(nombre);
    String descripcion = tDescripcion.getText();
    System.out.println(descripcion);
    String precioS = tPrecio.getText();
    String existenciaS = tExistencia.getText();
    String tipo = tTipo.getText();
    double precio = 0;
    double existencia = 0;
    try {
      precio = Double.parseDouble(precioS);
      existencia = Double.parseDouble(existenciaS);
    } catch (NumberFormatException e) {
      System.out.println("si entró");
    }
    System.out.println(precio);
    System.out.println(existencia);
    System.out.println(tipo);
    Inventario inv = new Inventario();
    inv.agregarProducto(nombre, descripcion, precio, existencia, tipo);
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Información");
    alert.setHeaderText(null);
    alert.setContentText("Producto guardado");

    alert.showAndWait();
    
  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }

}
