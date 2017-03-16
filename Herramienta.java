/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ll;

import java.io.Serializable;

/**
 *
 * @author esmeralda
 * @since 15/03/17
 *
 */
public class Herramienta implements Serializable{
  private String clave; 
  private String nombre;
  private String descripcion; 
  private double precioCompra;
  private int existencia;
  private double precioVenta;
  private String tipoUnidad;

    public Herramienta(String clave, String nombre, String descripcion, double precioCompra, int existencia, double precioVenta, String tipoUnidad) {
        this.clave = clave;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.existencia = existencia;
        this.precioVenta = precioVenta;
        this.tipoUnidad = tipoUnidad;
    }

    
    public Herramienta() {
    }


  @Override
    public String toString() {
    return ""+clave+" ~ "+nombre+" ~ $: " + precioVenta;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
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

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(String tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }
  
    public boolean disminuir(int cantidad){
    if (existencia-cantidad >= 0) {
      existencia -= cantidad;
      return true;
    } else {
      return false; 
    }
  }
 
}
