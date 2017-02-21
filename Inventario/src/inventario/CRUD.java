package inventario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Esmeralda Jimenez Ramos
 */

public class CRUD {
  Archivo archivo = new Archivo(); //Objeto de clase archivo, permite guardar y obtener el arraylist serializado
  ArrayList<Producto> lista; //Para guardar la arraylist obtenida del archivo
  Teclado teclado = new Teclado(); //permite la elctura de entradas por teclado
  int clave; //permite asignar una clave a cada producto 
  /**
   * Al construir el objeto verificamos si ya existe una lista dentro del archivo
   * de ser así la recuperamos, sino creamos una nueva
   */
  public CRUD(){
    if (archivo.existeArchivo()) {
      lista = archivo.leerArchivo();
      clave = lista.size();
    } else {
      lista = new ArrayList();
    }
  }
  /**
   * Recolecta los datos del producto, luego verifica que no exista en la lista
   * Si ya existe, suma cantidades y promedia costos
   * Si no existe lo agrega a la lista
   */
  public void agregar(){
    Producto producto = new Producto();
    producto.setClave("S150"+clave);
    System.out.printf("Nombre: ");
    producto.setNombre(teclado.leerCadena());
    System.out.printf("Descripción: ");
    producto.setDescripcion(teclado.leerCadena());
    System.out.printf("Precio de compra: ");
    producto.setPrecioCompra(teclado.leerDoble());
    System.out.printf("Existencias: ");
    producto.setExistencia(teclado.leerEnteros());
    System.out.printf("Tipo de unidad: ");
    producto.setTipoUnidad(teclado.leerCadenaPostEntero());
    
    int revision = revisar(producto);
    if (revision != -1) {
      lista.get(revision).setExistencia(lista.get(revision).getExistencia() + producto.getExistencia());
      double formula = lista.get(revision).getExistencia() * lista.get(revision).getPrecioCompra();
      formula += producto.getExistencia() * producto.getPrecioCompra();
      formula = formula / (lista.get(revision).getExistencia());
      lista.get(revision).setPrecioCompra(formula);
      archivo.escribirArchivo(lista);
      System.out.println("Guardado exitosamente\nSe actualizaron datos del producto existente");
    } else {
      lista.add(producto);
      archivo.escribirArchivo(lista);
      System.out.println("Guardado exitosamente \n Clave: S150"+clave);
    }
  }
  /**
   * Permite consultar un articulo usando su nombre, obtiene los objetos de la lista
   * y luego realiza comparaciones del atributo nombre con el nombre dado por el usuario
   */
  public void consultarNombre(){
    if (lista.size() > 0) {
      boolean encontrado = false; 
      String nombre;
      
      System.out.println("Ingresa el nombre del producto: ");
      nombre = teclado.leerCadena();
      
      for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).getNombre().equals(nombre)) {
          System.out.println("Clave: "+lista.get(i).getClave());
          System.out.println("Nombre: "+lista.get(i).getNombre());
          System.out.println("Descripción: "+lista.get(i).getDescripcion());
          System.out.println("Precio de compra: "+lista.get(i).getPrecioCompra());
          System.out.println("Existencias: "+lista.get(i).getExistencia());
          System.out.println("Tipo de unidad: "+lista.get(i).getTipoUnidad());
          encontrado = true; 
        } 
      }
      if (encontrado != true) {
        System.out.println("No se han encontrado coincidencias");
      }
    } else {
      System.out.println("No hay productos en el inventario");
    }
  }
  /**
   * Permite consultar un articulo usando su clave, obtiene los objetos de la lista
   * y luego realiza comparaciones del atributo clave con la clave dada por el usuario
   */
  public void consultarClave(){
    if (lista.size() > 0) {
      boolean encontrado = false; 
      String claves;
      
      System.out.println("Ingresa la clave del producto: ");
      claves = teclado.leerCadena();
      
      for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).getNombre().equals(claves)) {
          System.out.println("Clave: "+lista.get(i).getClave());
          System.out.println("Nombre: "+lista.get(i).getNombre());
          System.out.println("Descripción: "+lista.get(i).getDescripcion());
          System.out.println("Precio de compra: "+lista.get(i).getPrecioCompra());
          System.out.println("Existencias: "+lista.get(i).getExistencia());
          System.out.println("Tipo de unidad: "+lista.get(i).getTipoUnidad());
          encontrado = true; 
        } 
      }
      if (encontrado != true) {
        System.out.println("No se han encontrado coincidencias");
      }
    } else {
      System.out.println("No hay productos en el inventario");
    }
  }
  /**
   * Permite consultar un articulo usando su descripcion, obtiene los objetos de la lista
   * y luego realiza comparaciones del atributo descripcion con la caracteristica dada por el usuario
   */
  public void consultarDescripcion(){
    if (lista.size() > 0) {
      boolean encontrado = false; 
      String descripcion;
      int contenido; 
      
      System.out.println("Ingresa una caracteristica del articulo: ");
      descripcion = teclado.leerCadena();
      
      for (int i = 0; i < lista.size(); i++) {
        contenido = lista.get(i).getDescripcion().indexOf(descripcion);
        if (contenido != -1) {
          System.out.println("Clave: "+lista.get(i).getClave());
          System.out.println("Nombre: "+lista.get(i).getNombre());
          System.out.println("Descripción: "+lista.get(i).getDescripcion());
          System.out.println("Precio de compra: "+lista.get(i).getPrecioCompra());
          System.out.println("Existencias: "+lista.get(i).getExistencia());
          System.out.println("Tipo de unidad: "+lista.get(i).getTipoUnidad());
          encontrado = true; 
        } 
      }
      if (encontrado != true) {
        System.out.println("No se han encontrado coincidencias");
      }
    } else {
      System.out.println("No hay productos en el inventario");
    }
  }
  /**
   * Permite editar un objeto de la lista, realiza comparaciones con la clave del objeto y la que es pro-
   * porcionada por el usuario, cuando encuentra el objeto correspondiente solicita la captura de datos.
   */
  public void editar(){
    if (lista.size() > 0) {
      boolean encontrado = false; 
      String claves;
      
      System.out.println("Ingresa la clave del producto: ");
      claves = teclado.leerCadena();
      
      for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).getNombre().equals(claves)) {
          System.out.println("\tIngresa los datos nuevos");
          System.out.printf("Nombre: ");
          lista.get(i).setNombre(teclado.leerCadena());
          System.out.printf("Descripción: ");
          lista.get(i).setDescripcion(teclado.leerCadena());
          System.out.printf("Precio de compra: ");
          lista.get(i).setPrecioCompra(teclado.leerDoble());
          System.out.printf("Existencias: ");
          lista.get(i).setExistencia(teclado.leerEnteros());
          System.out.printf("Tipo de unidad: ");
          lista.get(i).setTipoUnidad(teclado.leerCadenaPostEntero());
          
          archivo.escribirArchivo(lista);
          System.out.println("Guardado exitosamente");
          encontrado = true; 
        } 
      }
      if (encontrado != true) {
        System.out.println("No se han encontrado coincidencias");
      }
    } else {
      System.out.println("No hay productos en el inventario");
    }
  }
  /**
   * Permite eliminar un elemento del arraylist de objetos, solicita la clave, realiza comparaciones y si 
   * encuentra el objeto, simplemente lo elimina
   */
  public void eliminar(){
    if (lista.size() > 0) {
      boolean encontrado = false; 
      String claves;
      
      System.out.println("Ingresa la clave del producto: ");
      claves = teclado.leerCadena();
      
      for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).getNombre().equals(claves)) {
          lista.remove(i);
          archivo.escribirArchivo(lista);
          System.out.println("Eliminado con exito");
          encontrado = true; 
        } 
      }
      if (encontrado != true) {
        System.out.println("No se han encontrado coincidencias");
      }
    } else {
      System.out.println("No hay productos en el inventario");
    }
  }
  /**
   * Hace usa del metodo sort de la clase Collections para ordenar los elementos de la lista en descendente
   * respecto al nombre del articulo, luego recorre la lista e imprime los datos en pantalla
   */
  public void mostrarNombre(){
    Collections.sort(lista, new Comparator<Producto>() {
      @Override
      public int compare(Producto o1, Producto o2) {
        return o1.getNombre().compareTo(o2.getNombre());
      }
    });
    for (int i = 0; i < lista.size(); i++) {
      System.out.printf(i+1+") Nombre: "+lista.get(i).getNombre());
      System.out.printf(" | Clave: "+lista.get(i).getClave());
      System.out.printf(" | Desc: "+lista.get(i).getDescripcion());
      System.out.printf(" | $: "+lista.get(i).getPrecioCompra());
      System.out.printf(" | Exist: "+lista.get(i).getExistencia());
      System.out.printf(" | Unidad: "+lista.get(i).getTipoUnidad());
      System.out.println("");
    }
  }
  /**
   * Recorre la lista y acumula la multiplicacion del numero de piezas de cada producto por su costo unitario
   */
  public void activosTotales(){
    double activos = 0; 
    if (lista.size() > 0) {
      for (int i = 0; i < lista.size(); i++) {
        activos += (lista.get(i).getPrecioCompra() * lista.get(i).getExistencia());
      }
      System.out.println("Los activos totales son: $"+activos);
    } else {
      System.out.println("No hay productos en el inventario");
    }
  }
  /**
   * 
   * @param producto
   * @return Devuelve la posición de la lista en la que esta el objeto
   * Si el regreso es -1 entonces no existe en la lista
   */
  public int revisar(Producto p){
    if (lista.size() > 0) {
      for (int i = 0; i < lista.size(); i++) {
        if (p.getNombre() == lista.get(i).getNombre() && p.getDescripcion() == lista.get(i).getDescripcion() 
            && p.getTipoUnidad() == lista.get(i).getTipoUnidad()) {
          return i;
        } 
      }
    } 
    return -1; 
  }
}
