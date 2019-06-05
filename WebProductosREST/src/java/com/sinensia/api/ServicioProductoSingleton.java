
package com.sinensia.api;

import java.util.ArrayList;


public class ServicioProductoSingleton {
    
    private ArrayList<Producto> listaProducto;
    
    
    //PONEMOS METODOS
    public void insertar (Producto p){
    listaProducto.add(p);
     }
    public Producto modificar (Producto p){
      p.setNombre(p.getNombre() + " -modificado");
      p.setPrecio(p.getPrecio() + " -modificado");
      return p;
    }
    public ArrayList<Producto> obtenerTodos(){
        return listaProducto;
    }
    
    //desde aqui patron singleton necesario
    // La única instancia es privada
    private static ServicioProductoSingleton instancia = null;
    //Nadie puede hacer new excepto dentro de esta clase.
    //puede ser protected
    private ServicioProductoSingleton(){
        this.listaProducto = new ArrayList<>();
    
        this.listaProducto = new ArrayList<>();
    }
    //creamos el metodo publico estatico que solo devuelve un objeto(por ser singleton)
    //la primera vez que se llama al método, se crea la instancia
    //A partir de ese momento hasta que la aplicación termine
    //la instancia seguirá "viva" y es devuelta por el método,
    // venga de donde venga la llamada.
    public static ServicioProductoSingleton getInstancia(){
        if(instancia == null )
            instancia = new ServicioProductoSingleton();
        return instancia;
    }
// hasta aquí código necesario para que sea Singleton
    
}
