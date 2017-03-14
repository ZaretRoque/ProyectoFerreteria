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

  @FXML
  public void guardar(ActionEvent e) {
    inv = new Inventario();
    String clave = tClave.getText();
    indice = inv.buscarClave(clave);
    String nombre = tNombre.getText();
    String descripcion = tDescripcion.getText();
    String precioS = tPrecio.getText();
    String existenciaS = tExistencia.getText();
    String tipo = tTipo.getText();
    double precio = Double.parseDouble(precioS);
    double existencia = Double.parseDouble(existenciaS);
    System.out.println(nombre+"\n"+descripcion+"\n"+precio+"\n"+existencia+"\n"+tipo);
    
    inv.editarInterfaz(nombre, descripcion, precio, existencia, tipo, indice);
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Información");
    alert.setHeaderText(null);
    alert.setContentText("Datos actualizados");

    alert.showAndWait();
  }

  @FXML
  public void buscar() {
    inv = new Inventario();
    Producto prod = new Producto();
    String clave = tClave.getText();
    indice = inv.buscarClave(clave);
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
  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }

}
