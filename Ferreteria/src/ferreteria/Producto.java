/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import java.io.Serializable;


/**
 *Define la clase Producto, implementa la interfaz serializable para poder guardar la información
 * en un archivo
 * @author zaret
 */
public class Producto implements Serializable{
  private String clave;
  private String nombre;
  private String descripcion;
  private double precioCompra;
  private double existencia;
  private String tipoUnidad;

  public Producto() {
  }

  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public double getPrecioCompra() {
    return precioCompra;
  }

  public void setPrecioCompra(double precioCompra) {
    this.precioCompra = precioCompra;
  }

  public double getExistencia() {
    return existencia;
  }

  public void setExistencia(double existencia) {
    this.existencia = existencia;
  }

  public String getTipoUnidad() {
    return tipoUnidad;
  }

  public void setTipoUnidad(String tipoUnidad) {
    this.tipoUnidad = tipoUnidad;
  }
  
  @Override
  public String toString(){
    return "Clave: "+clave+"\nNombre: "+nombre+"\nDescripción: "+descripcion+"\nPrecio: "
        +precioCompra+"\nExistencia: "+existencia+"\nUnidad: "+tipoUnidad;
  }
  
  
}
