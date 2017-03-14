/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author zaret
 */
public class Inventario {
  Archivo arch = new Archivo();
  ArrayList<Producto> stock;
  int clave;

  public int getClave() {
    return clave;
  }
  
  
  public Inventario(){
    if(arch.existeStock()){
      stock = arch.leerStock();
      clave = stock.size();
    }else{
      stock = new ArrayList();
    }
  }
  
  /**
   * Inicializa un nuevo producto y lo añade al arrayList
   */
  public void agregarProducto(String nombre, String descripcion, double precio, double existencia, String tipo){
    //Teclado tec = new Teclado();
    Producto prod = new Producto();
    //String info;
    //double aux;
    //System.out.println("Ingresa los datos del producto");
    prod.setClave("PK-"+clave);
    //System.out.println("Nombre:");
    //info = tec.leerString();
    prod.setNombre(nombre);
    //System.out.println("Descripción");
    //info = tec.leerString();
    prod.setDescripcion(descripcion);
    //System.out.println("Tipo de unidad");
    //info = tec.leerString();
    prod.setTipoUnidad(tipo);
    //System.out.println("Precio de compra");
    //aux = tec.leerDouble();
    prod.setPrecioCompra(precio);
    //System.out.println("Existencia");
    //aux = tec.leerDouble();
    prod.setExistencia(existencia);
    stock.add(prod);
    arch.escribirStock(stock);
  }
  
  /**
   * Muestra todos los productos del inventario
   */
  public void mostrarInventario(){
    for(int i=0;i<stock.size();i++){
      System.out.println(stock.get(i).toString());
    }
  }
  
  /**
   * Muestra la información del producto
   * @param indice Espera un entero para indicar la posición del array en la que se encuentra
   */
  public String mostrarInformacion(int indice){
    return stock.get(indice).toString();
  }
  
  /**
   * Busca la clave que se recibe como argumento en los objetos del array, retorna el índice del 
   * elemento encontrado. Es insensible a mayúsculas
   * @param claveB String a buscar
   * @return Índice del array donde se encontró la clave
   */
  public int buscarClave(String claveB){
    int indice=0;
    for(int i=0;i<stock.size();i++){
      String clave = stock.get(i).getClave();
      if(clave.equalsIgnoreCase(claveB)){
        indice = i;
        break;
      }
    }
    return indice;
  }
  
  /**
   * Elimina un elemento del inventario
   */
  public void eliminarElemento(int indice){
    stock.remove(indice);
    arch.escribirStock(stock);
  }
  
  /**
   * Permite editar la información de un producto
   * @param indice Posición donde se encuentra el producto a editar
   */
 public void editar(int indice){
    System.out.println("¿Qué vas a editar?\n1 Nombre\n2 Descripción\n3 Unidad\n4 Precio"
        + "\n5 Existencia");
    Teclado tec = new Teclado();
    int resp = tec.leerEntero();
    System.out.println("Ingresa el nuevo valor");
    String nuevo;
    double nuevoo;
    tec.limpiarBuffer();
    switch(resp){
      case 1:
        nuevo = tec.leerString();
        stock.get(indice).setNombre(nuevo);
        break;
      case 2:
        nuevo = tec.leerString();
        stock.get(indice).setDescripcion(nuevo);
        break;
      case 3:
        nuevo = tec.leerString();
        stock.get(indice).setTipoUnidad(nuevo);
        break;
      case 4:
        nuevoo = tec.leerDouble();
        stock.get(indice).setPrecioCompra(nuevoo);
        break;
      case 5:
        nuevoo = tec.leerDouble();
        stock.get(indice).setExistencia(nuevoo);
        break;
    }
    arch.escribirStock(stock);
  }
 
 public void editarInterfaz(String nombre, String descripcion, double precio, double existencia, String tipo, int indice){
     stock.get(indice).setNombre(nombre);
     stock.get(indice).setDescripcion(descripcion);
     stock.get(indice).setPrecioCompra(precio);
     stock.get(indice).setExistencia(existencia);
     stock.get(indice).setTipoUnidad(tipo);
   }
 
 /**
   * Busca el nombre en los objetos del array, retorna el índice donde se encontró. Insensible a 
   * mayúsculas
   * @param nombre String a buscar
   * @return Índice donde se encontró el nombre
   */
  public int buscarNombre(String nombre){
    Producto p = new Producto();
    int indice=0;
    for(int i=0;i<stock.size();i++){
     // p = stock[i];
      String st = stock.get(i).getNombre();
      if(st.equalsIgnoreCase(nombre)){
        indice = i;
        break;
      }
    }
    return indice;
  }
  
  /**
   * Busca la descripción en el arreglo, retorna la posición donde se encontró el elemento. 
   * Insensible a mayúsculas
   * @param descripcion La descripción a buscar en el arreglo
   * @return La posición donde se encontró la descripción
   */
  public int buscarDescripcion(String descripcion){
    Producto p = new Producto();
    int indice=0;
    for(int i=0;i<stock.size();i++){
     // p = stock[i];
      String st = stock.get(i).getNombre();
      if(st.equalsIgnoreCase(descripcion)){
        indice = i;
        break;
      }
    }
    return indice;
  }
  
  /**
   * Calcula el total que hay invertido en el stock
   */
  public void calcularTotal(){
    double total=0;
    for(int i=0;i<stock.size();i++){
      double precio = stock.get(i).getPrecioCompra();
      double cantidad = stock.get(i).getExistencia();
      total += (precio*cantidad);
    }
    System.out.println("El total es: "+total);
  }
  
  /**
   * Ordena los productos en orden alfabético, tomando su nombre como criterio
   */
   public void ordenarNombre(){
    Collections.sort(stock, new Comparator<Producto>() {
      @Override
      public int compare(Producto o1, Producto o2) {
        return o1.getNombre().compareTo(o2.getNombre());
      }
    });
  }
   
   /**
    * Ordena los productos de acuerdo a su clave
    */
   public void ordenarClave(){
    Collections.sort(stock, new Comparator<Producto>() {
      @Override
      public int compare(Producto o1, Producto o2) {
        return o1.getClave().compareTo(o2.getClave());
      }
    });
  }
   
   /**
    * Realiza una venta de producto, modifica la existencia
    */
   public void vender(){
     Teclado tec = new Teclado();
     System.out.println("Ingresa la clave del producto");
     String clavee = tec.leerString();
     int indice = buscarClave(clavee);
     
     if(indice > 0){
       if(stock.get(indice).getExistencia() == 0){
         System.out.println("No hay existencias");
       }else{
         System.out.println("Ingresa la cantidad a vender");
         int cantidad = tec.leerEntero();
         if(cantidad <= stock.get(indice).getExistencia()){
           double precio = cantidad * stock.get(indice).getPrecioCompra();
           double ganancia = precio * 0.5;
           double subtotal = precio + ganancia;
           double iva = subtotal * 0.16;
           double total = subtotal + iva;
           stock.get(indice).setExistencia(stock.get(indice).getExistencia()-cantidad);
           Venta ven = new Venta(clavee, cantidad, total, ganancia); /*crea un objeto Venta para 
           guardarlo en archivo*/
           RegistroVentas rv = new RegistroVentas(); //Este objeto se encarga de controlar las ventas
           rv.agregarVenta(ven);
           arch.escribirStock(stock);
           System.out.println("Total a pagar: "+total);
         }else{
           System.out.println("No hay suficiente producto");
         }
       }
     }
   }
   
   public Producto getProducto(int indice){
     return stock.get(indice);
   }
   
   
}
