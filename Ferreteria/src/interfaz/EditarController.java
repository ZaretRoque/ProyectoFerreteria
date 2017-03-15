/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import ferreteria.Inventario;
import ferreteria.Producto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zaret
 */
public class EditarController implements Initializable {

  Inventario inv = new Inventario();
  int indice;

  @FXML
  private TextField tClave;

  @FXML
  private TextField tNombre;

  @FXML
  private TextField tDescripcion;

  @FXML
  private TextField tPrecio;

  @FXML
  private TextField tExistencia;

  @FXML
  private TextField tTipo;

  @FXML
  private Button bBuscar;

  @FXML
  private Button bGuardar;

  @FXML//Se ejecuta cuando se presiona el botón Guardar
  public void guardar(ActionEvent e) {
    if (validar()) {

      inv = new Inventario();
      String clave = tClave.getText();
      indice = inv.buscarClave(clave);
      String nombre = tNombre.getText();
      String descripcion = tDescripcion.getText();
      String precioS = tPrecio.getText();
      String existenciaS = tExistencia.getText();
      String tipo = tTipo.getText();
      double precio = 0;
      double existencia = 0;
      try {//Manejar la excepción en caso de que se haya ingresado una letra
        precio = Double.parseDouble(precioS);
        existencia = Double.parseDouble(existenciaS);
      } catch (NumberFormatException exc) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Sólo números en campos Precio y Existencia");
        alert.showAndWait();
        return;
      }
      System.out.println(nombre + "\n" + descripcion + "\n" + precio + "\n" + existencia + "\n" + tipo);

      inv.editarInterfaz(nombre, descripcion, precio, existencia, tipo, indice);
      //Mostrar mensaje al usuario
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Información");
      alert.setHeaderText(null);
      alert.setContentText("Datos actualizados");
      alert.showAndWait();
      
      limpiar();
      inhabilitar();
    } else {
      //Mostrar mensaje al usuario
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText(null);
      alert.setContentText("Campos vacíos, intenta de nuevo");
      alert.showAndWait();
    }
  }

  @FXML//Se ejecuta cuando se presiona el botón Buscar
  public void buscar() {
    String clave = tClave.getText();
    if (clave.length() > 0) {
      
      inv = new Inventario();
      Producto prod = new Producto();
      indice = inv.buscarClave(clave);
      
      if (indice != -1) {
        
        prod = inv.getProducto(indice);
        tNombre.setText(prod.getNombre());
        tDescripcion.setText(prod.getDescripcion());
        double precioD = prod.getPrecioCompra();
        String precio = Double.toString(precioD);
        tPrecio.setText(precio);
        double existenciaD = prod.getExistencia();
        String existencia = Double.toString(existenciaD);
        tExistencia.setText(existencia);
        tTipo.setText(prod.getTipoUnidad());
        habilitar();
        
      } else {
        //Mostrar mensaje al usuario
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("No se encontró el producto");
        alert.showAndWait();
      }
    } else {
      //Mostrar mensaje al usuario
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText(null);
      alert.setContentText("Ingresa una clave para buscar");
      alert.showAndWait();
    }
  }
 /**
  * Limpia los campos de texto
  */
  public void limpiar() {
    tNombre.setText(null);
    tDescripcion.setText(null);
    tPrecio.setText(null);
    tExistencia.setText(null);
    tTipo.setText(null);
    tClave.setText(null);
  }

  /**
   * Inhabilita los campos de texto 
   */
  public void inhabilitar() {
    tNombre.setEditable(false);
    tDescripcion.setEditable(false);
    tPrecio.setEditable(false);
    tExistencia.setEditable(false);
    tTipo.setEditable(false);
  }

  /**
   * Habilita los campos de texto
   */
  public void habilitar() {
    tNombre.setEditable(true);
    tDescripcion.setEditable(true);
    tPrecio.setEditable(true);
    tExistencia.setEditable(true);
    tTipo.setEditable(true);
  }

  /**
   * Valida que los campos de texto tengan contenido
   * @return True si tienen contenido, false en caso contrario
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
