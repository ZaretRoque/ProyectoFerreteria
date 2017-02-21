
package ferreteria;

import java.io.Serializable;

/**
 *
 * @author Zaret Roque
 */
public class Venta implements Serializable{

  private String folio;
  private String claveProducto;
  private int cantidadProducto;
  private double total;
  
  public Venta(){
    
  }

  public Venta(String claveProducto, int cantidadProducto, double total) {
    this.claveProducto = claveProducto;
    this.cantidadProducto = cantidadProducto;
    this.total = total;
  }
  

  public String getFolio() {
    return folio;
  }

  public void setFolio(String folio) {
    this.folio = folio;
  }

  public String getClaveProducto() {
    return claveProducto;
  }

  public void setClaveProducto(String claveProducto) {
    this.claveProducto = claveProducto;
  }

  public int getCantidadProducto() {
    return cantidadProducto;
  }

  public void setCantidadProducto(int cantidadProducto) {
    this.cantidadProducto = cantidadProducto;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }
  
  @Override
  public String toString(){
    return "Folio: "+folio+" || Producto: "+claveProducto+" || Cantidad: "+cantidadProducto
        +" || Total: "+total;
  }
  
}
