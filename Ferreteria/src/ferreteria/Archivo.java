/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Clase encargada de serializar los objetos del inventario
 * @author zaret
 */
public class Archivo {
  
  File archivo;
  FileOutputStream fos;
  ObjectOutputStream os;
  ObjectInputStream ois;
  FileInputStream fis;
  
  public Archivo(){
  }
  
  /**
   * Se encarga de enviar un ArrayList de productos a un archivo para su uso posterior
   * @param prod Recibe un objeto ArrayList de tipo Producto
   */
  public void escribirStock(ArrayList<Producto> prod){
    try{
      fos = new FileOutputStream("stock.txt");
      os = new ObjectOutputStream(fos);
      os.writeObject(prod);
      os.close();
    }catch(FileNotFoundException e){
      e.printStackTrace();
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  
  /**
   * Lee el ArrayList guardado
   * @return El ArrayList que contiene los Productos
   */
  public ArrayList<Producto> leerStock(){
    ArrayList<Producto> temp = null;
    try{
      fis = new FileInputStream("stock.txt");
      ois = new ObjectInputStream(fis);
      temp = (ArrayList<Producto>) ois.readObject();
      ois.close();
      } catch (IOException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
      
    }
    return temp;
    }
  
  /**
   * Verifica que exista un archivo del cual leer el Array
   * @return True, si el archivo existe, False si no existe
   */
  public boolean existeStock(){
    try{
      fis = new FileInputStream("stock.txt");
      return true;
    }catch(FileNotFoundException e){
      return false;
    }
  }
  
   /**
   * Se encarga de enviar un ArrayList de ventas a un archivo para su uso posterior
   * @param venta Recibe un objeto ArrayList de tipo Producto
   */
  public void escribirVenta(ArrayList<Venta> venta){
    try{
      fos = new FileOutputStream("ventas.txt");
      os = new ObjectOutputStream(fos);
      os.writeObject(venta);
      os.close();
    }catch(FileNotFoundException e){
      e.printStackTrace();
    }catch(IOException e){
      e.printStackTrace();
    }
  }
  
  /**
   * Lee el ArrayList guardado
   * @return El ArrayList que contiene las Ventas
   */
  public ArrayList<Venta> leerVenta(){
    ArrayList<Venta> temp = null;
    try{
      fis = new FileInputStream("ventas.txt");
      ois = new ObjectInputStream(fis);
      temp = (ArrayList<Venta>) ois.readObject();
      ois.close();
      } catch (IOException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
      
    }
    return temp;
    }
  
  /**
   * Verifica que exista un archivo del cual leer el Array
   * @return True, si el archivo existe, False si no existe
   */
 public boolean existeVenta(){
    try{
      fis = new FileInputStream("ventas.txt");
      return true;
    }catch(FileNotFoundException e){
      return false;
    }
  }
  }

