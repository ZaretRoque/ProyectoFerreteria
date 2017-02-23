
package ferreteria;

import java.util.ArrayList;

/**
 *
 * @author Zaret Roque
 */
public class RegistroVentas {
Archivo arch = new Archivo();
ArrayList<Venta> ventas;
int folio;

public RegistroVentas(){
  if(arch.existeVenta()){
    ventas = arch.leerVenta();
    folio = ventas.size();
  }else{
    ventas = new ArrayList();
  }
}

/**
 * Agrega una nueva venta al ArrayList
 * @param ven la venta a añadir
 */
public void agregarVenta(Venta ven){
  ven.setFolio("VK-"+folio);
  ventas.add(ven);
  arch.escribirVenta(ventas);
}

/**
 * Recorre el array y lo muestra
 */
public void mostrarVentas(){
  for(int i=0;i<ventas.size();i++){
    System.out.println(ventas.get(i).toString());
  }
      
}

/**
 * Recorre el array de ventas y compara las fechas con el parámetro recibido, muestra las ventas 
 * que coincidan
 * @param fecha Un String con la fecha a comparar (dd/mm/aaaa) solo números
 */
public void verVentasFecha(String fecha){
  int cont=0;
  for(int i=0;i<ventas.size();i++){
    String f = ventas.get(i).getFecha();
    if(f.equals(fecha)){
      System.out.println(ventas.get(i).toString());
      cont++;
    }
  }
  if(cont==0){
    System.out.println("No se encontraron coincidencias");
  }
}
}
