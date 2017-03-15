/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import ferreteria.Inventario;
import ferreteria.Producto;
import ferreteria.RegistroVentas;
import ferreteria.Venta;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zaret
 */
public class VenderController implements Initializable {

  private Stage stagePrincipal;

  public void setStagePrincipal(Stage stagePrincipal) {
    this.stagePrincipal = stagePrincipal;
  }
  @FXML
  TextField tClave;

  @FXML
  TextField tCantidad;

  @FXML
  Label labTotal;

  @FXML
  Button bVender;

  @FXML//Se ejecuta al presionar el botón Vender
  public void vender() {
    String clave = tClave.getText();
    String cantidadS = tCantidad.getText();
    int cantidad = 0;
    
    if (clave.length() > 0 && cantidadS.length() > 0) {
      Inventario inv = new Inventario();
      
      try {//Manejar la excepción en caso de que se haya ingresado una letra
        cantidad = Integer.parseInt(cantidadS);
      } catch (NumberFormatException e) {
        //Mostrar mensaje al usuario
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Sólo números en campo Cantidad");
        alert.showAndWait();
        return;
      }
      
      Producto prod = new Producto();
      int indice = inv.buscarClave(clave);
      prod = inv.getProducto(indice);
      double existencia = prod.getExistencia();
      
      if ((cantidad > 0) && (cantidad <= existencia)) {
        
        double precio = cantidad * prod.getPrecioCompra();
        double ganancia = precio * 0.5;
        double subtotal = precio + ganancia;
        double iva = subtotal * 0.16;
        double total = subtotal + iva;
        prod.setExistencia(existencia - cantidad);
        Venta ven = new Venta(clave, cantidad, total, ganancia);
        RegistroVentas rv = new RegistroVentas();
        rv.agregarVenta(ven);
        inv.reemplazar(indice, prod);
        String totalS = Double.toString(total);
        labTotal.setText(totalS);
        System.out.println("Vendido");
        //Mostrar mensaje al usuario
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText("Venta procesada correctamente");
        alert.showAndWait();
      } else {
        //Mostrar mensaje al usuario
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("No hay producto suficiente");
        alert.showAndWait();
      }
    } else {
      //Mostrar mensaje al usuario
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText(null);
      alert.setContentText("Ingresa datos del producto");
      alert.showAndWait();
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
