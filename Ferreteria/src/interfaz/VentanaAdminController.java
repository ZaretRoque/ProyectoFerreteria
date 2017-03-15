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

  @FXML//Se ejecuta al presionar el botón Agregar
  public void agregar() {
    if (validar()) {
      
      String nombre = tNombre.getText();
      System.out.println(nombre);
      String descripcion = tDescripcion.getText();
      System.out.println(descripcion);
      String precioS = tPrecio.getText();
      String existenciaS = tExistencia.getText();
      String tipo = tTipo.getText();
      double precio = 0;
      double existencia = 0;
      
      try {//Manejar la excepción en caso de que se haya ingresado una letra
        precio = Double.parseDouble(precioS);
        existencia = Double.parseDouble(existenciaS);
      } catch (NumberFormatException e) {
        //Mostrar mensaje al usuario
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Sólo números en campos Precio y Existencia");
        alert.showAndWait();
        return;
      }
      System.out.println(precio);
      System.out.println(existencia);
      System.out.println(tipo);

      Inventario inv = new Inventario();
      inv.agregarProducto(nombre, descripcion, precio, existencia, tipo);
      //Mostrar mensaje al usuario
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Información");
      alert.setHeaderText(null);
      alert.setContentText("Producto guardado");
      alert.showAndWait();
      limpiar();
    } else {
      //Mostrar mensaje al usuario
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText(null);
      alert.setContentText("Campos vacíos, intenta de nuevo");
      alert.showAndWait();
    }
  }

  /**
   * Limpiar los TextField
   */
  public void limpiar() {
    tNombre.setText(null);
    tDescripcion.setText(null);
    tPrecio.setText(null);
    tExistencia.setText(null);
    tTipo.setText(null);
  }

  /**
   * Valida que se haya ingresado información
   * @return True si fue ingresada, False en caso contrario
   */
  public boolean validar() {
    String n = tNombre.getText();
    String d = tDescripcion.getText();
    String p = tPrecio.getText();
    String e = tExistencia.getText();
    String t = tTipo.getText();
    if (n.length() > 0 && d.length() > 0 && p.length() > 0 && e.length() > 0 && t.length() > 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }

}
