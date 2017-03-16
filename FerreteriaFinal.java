/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ll;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


import javafx.stage.Stage;

/**
 *
 * @author esmeralda
 * @since 14/03/17
 */
public class FerreteriaFinal extends Application {
    
    
    Archivo archivo = new Archivo("Ferreteria.txt"); //Objeto de clase archivo, permite guardar y obtener el arraylist serializado
    ArrayList<Herramienta> lista; //Para guardar la arraylist obtenida del archivo
    int clave; //permite asignar una clave a cada producto 

    /**
     *
     * @param primaryStage
     */
    public void ventanaInventario(Stage primaryStage){
    ListView listaVentana = new ListView();
    Button botonBorrar = new Button();
    Button botonAgregar = new Button();
    Button botonActualizar = new Button();
    TextField textNombre = new TextField();
    TextField textPCompra = new TextField();
    TextField textClave = new TextField();
    TextField textPVenta = new TextField();
    TextField textExistencia = new TextField();
    TextField textUnidad = new TextField();
    Label nombre = new Label();
    Label Precio_de_compra= new Label();
    Label Precio_de_venta = new Label();
    Label Clave = new Label();
    Label Existencia = new Label();
    Label unidad = new Label();
    Label Descripcion = new Label();
    
    TextArea textDescripcion = new TextArea();
    
            Pane root = new Pane();
            Scene escena2 = new Scene(root, 650, 449);
            primaryStage.setScene(escena2);
            primaryStage.show();
            primaryStage.setResizable(false);
            
            botonBorrar.setText("Borrar");
            botonBorrar.setLayoutX(315.0);
            botonBorrar.setLayoutY(399);
            botonBorrar.setStyle("-fx-background-color: #FF1717;");
            
            botonAgregar.setText("Agregar");
            botonAgregar.setLayoutX(489.0);
            botonAgregar.setLayoutY(399);
            botonAgregar.setStyle("-fx-background-color: #00E45F;" );
            
            botonActualizar.setText("Actualizar");
            botonActualizar.setLayoutX(390.0);
            botonActualizar.setLayoutY(399);
            botonActualizar.setStyle("-fx-background-color: #8E8EFF;" );
            
            nombre.setText("Nombre: ");
            nombre.setLayoutX(263.0);
            nombre.setLayoutY(75.0);
            Precio_de_compra.setText("Precio de compra:");
            Precio_de_compra.setLayoutX(263.0);
            Precio_de_compra.setLayoutY(117.0);
            Precio_de_venta.setText("Precio de venta:");
            Precio_de_venta.setLayoutX(263.0);
            Precio_de_venta.setLayoutY(155.0);
            unidad.setText( "Tipo de unidad: ");
            unidad.setLayoutX(265.0);
            unidad.setLayoutY(195.0);
            Clave.setText( "Clave: ");
            Clave.setLayoutX(418.0);
            Clave.setLayoutY(27.0);
            Existencia.setText("Existencia: ");
            Existencia.setLayoutX(269.0);
            Existencia.setLayoutY(234.0);
            Descripcion.setText("Descripción: ");
            Descripcion.setLayoutX(263.0);
            Descripcion.setLayoutY(268.0);
            
            textClave.setLayoutX(470.0);
            textClave.setLayoutY(25.0);
            textClave.prefHeight(16.0);
            textClave.prefWidth(10.0);
            textNombre.setLayoutX(340.0);
            textNombre.setLayoutY(73.0);
            textNombre.prefHeight(26.0);
            textNombre.prefWidth(215.0);
            textPCompra.setLayoutX(400.0);
            textPCompra.setLayoutY(115.0);
            textPCompra.prefHeight(26.0);
            textPCompra.prefWidth(123.0);
            textPVenta.setLayoutX(390.0);
            textPVenta.setLayoutY(153.0);
            textPVenta.prefHeight(26.0);
            textPVenta.prefWidth(139.0);
            textExistencia.setLayoutX(370.0);
            textExistencia.setLayoutY(232.0);
            textExistencia.prefHeight(26.0);
            textExistencia.prefWidth(59.0);
            textUnidad.setLayoutX(390.0);
            textUnidad.setLayoutY(192.0);
            textUnidad.prefHeight(26.0);
            textUnidad.prefWidth(155.0);
            
            textDescripcion.setLayoutX(265.0);
            textDescripcion.setLayoutY(295.0);
            textDescripcion.setMaxSize(295.0, 88);
            
            listaVentana.setLayoutX(14.0);
            listaVentana.setLayoutY(25);
            listaVentana.setMaxSize(228.0,400.0);
            
            root.getChildren().add(botonBorrar);
            root.getChildren().add(botonAgregar);
            root.getChildren().add(botonActualizar);
            root.getChildren().add(Clave);
            root.getChildren().add(nombre);
            root.getChildren().add(Precio_de_compra);
            root.getChildren().add(Precio_de_venta);
            root.getChildren().add(Existencia);
            root.getChildren().add(unidad);
            root.getChildren().add(Descripcion);
            root.getChildren().add(textClave);
            root.getChildren().add(textNombre);
            root.getChildren().add(textPCompra);
            root.getChildren().add(textPVenta);
            root.getChildren().add(textUnidad);
            root.getChildren().add(textExistencia);
            root.getChildren().add(textDescripcion);
            root.getChildren().add(listaVentana);
            
            botonAgregar.setOnAction((ActionEvent event) -> {
            Herramienta h = new Herramienta();
            textClave.setText("S150"+clave);
            h.setClave(textClave.getText());
            h.setDescripcion(textDescripcion.getText());
            int existencia = Integer.parseInt(textExistencia.getText());
            h.setExistencia(existencia);
            h.setNombre(textNombre.getText());
            double precioC = Double.parseDouble(textPCompra.getText());
            h.setPrecioCompra(precioC);
            double precov = (precioC*.5)+precioC;
            String precioV = Double.toString(precov);
            textPVenta.setText(precioV);
            h.setTipoUnidad(textUnidad.getText());
            
            int revision = revisar(h);
            lista = new ArrayList();
            if (revision != -1) {
                lista.get(revision).setExistencia(lista.get(revision).getExistencia() + h.getExistencia());
                double formula = lista.get(revision).getExistencia() * lista.get(revision).getPrecioCompra();
                formula += h.getExistencia() * h.getPrecioCompra();
                formula = formula / (lista.get(revision).getExistencia());
                lista.get(revision).setPrecioCompra(formula);
                archivo.salida(lista);
                System.out.println("Guardado exitosamente\nSe actualizaron datos del producto existente");
                revalidarLectura();
            } else {
                lista.add(h);
                archivo.salida(lista);
                System.out.println("Guardado exitosamente \n Clave: S150" + clave);
                revalidarLectura();
          }
        
            });
    }
    
    public void revalidarLectura(){
        if (archivo.existencia()) {
        lista = archivo.entrada();
        clave = lista.size();
        } else {
        lista = new ArrayList();
        }
    }
    
    /*
    *Revisamos si el producto que queremos insertar se encuentra ya registrado
    *si es así entonces tenemos que aumentar las existencias y aplicar la formula
    *para definir el precio de compra
    */
      public int revisar(Herramienta p){
    if (lista.size() > 0) {
      for (int i = 0; i < lista.size(); i++) {
        if (p.getNombre() == lista.get(i).getNombre() && p.getDescripcion() == 
                lista.get(i).getDescripcion()) {
          return i;
        } 
      }
    } 
    return -1; 
  }
      
      
    
    @Override
    public void start(Stage primaryStage) {
            ventanaInventario(primaryStage);
  
            
            
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
 
        
    }
    
}
