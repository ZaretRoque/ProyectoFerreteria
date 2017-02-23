
package ferreteria;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *Clase que define una venta
 * @author Zaret Roque
 */
public class Venta implements Serializable{

  private String folio;
  private String fecha;
  private String claveProducto;
  private int cantidadProducto;
  private double total;
  
  public Venta(){
    
  }

  public Venta(String claveProducto, int cantidadProducto, double total) {
    this.claveProducto = claveProducto;
    this.cantidadProducto = cantidadProducto;
    this.total = total;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); /* Crea un objeto para obtener la 
    fecha en el formato que se pasa como parámetro*/
    fecha = sdf.format(new Date()); //Obtiene la fecha, la formatea y la guarda en String
  }
  

  public String getFolio() {
    return folio;
  }

  public void setFolio(String folio) {
    this.folio = folio;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
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
    return "Folio: "+folio+" || Fecha: "+fecha+" || Producto: "+claveProducto+" || Cantidad: "+cantidadProducto
        +" || Total: "+total;
  }
  
}
