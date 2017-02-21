package inventario;

import java.io.Serializable;

/**
 *Se implementa la interfaz serializable para poder serializar objetos de este tipo en archivos
 * @author Esmeralda Jimenez Ramos
 */
public class Producto implements Serializable {
  private String clave; 
  private String nombre;
  private String descripcion; 
  private double precioCompra;
  private int existencia;
  private String tipoUnidad; 

  public void setClave(String clave) {
    this.clave = clave;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public void setPrecioCompra(double precioCompra) {
    this.precioCompra = precioCompra;
  }

  public void setExistencia(int existencia) {
    this.existencia = existencia;
  }

  public void setTipoUnidad(String tipoUnidad) {
    this.tipoUnidad = tipoUnidad;
  }

  public String getClave() {
    return clave;
  }

  public String getNombre() {
    return nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public double getPrecioCompra() {
    return precioCompra;
  }

  public int getExistencia() {
    return existencia;
  }

  public String getTipoUnidad() {
    return tipoUnidad;
  }
 
}
