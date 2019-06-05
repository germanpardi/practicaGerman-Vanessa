/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sinensia.api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Decoradores en forma de anotación
@WebServlet( asyncSupported = true , urlPatterns = "/api/productos")
public class ProductoRestController extends HttpServlet {
    
    private ServicioProductoSingleton servProd;
    
    
    @Override
    public void init(){
    servProd = ServicioProductoSingleton.getInstancia();
    }

@Override
@SuppressWarnings("empty-statement")
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        PrintWriter escritoRespuesta = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");
        
        
        BufferedReader bufRead = request.getReader();
        
        StringBuilder textoJson = new StringBuilder();
        for (String lineaJson = bufRead.readLine();
                lineaJson != null;
               lineaJson = bufRead.readLine()){//iteración 
        
        textoJson.append(lineaJson);
        
    }
        bufRead.close();
       
        System.out.println(">>>>>" + textoJson.toString().toUpperCase());
        
        Gson gson = new Gson();
        Producto producto = gson.fromJson(textoJson.toString(), Producto.class);
        System.out.println(">>>>>" + producto.getNombre());
        
        //producto.setNombre(producto.getNombre().toUpperCase());
        //producto.setPrecio("5000 bolivares");
        //si lo usas una vez
        //ServicioProductoSingleton.getInstancia().modificar(producto);
        //si lo usas más veces se guarda
        
        //ServicioProductoSingleton sps = ServicioProductoSingleton.getInstancia();
        servProd.modificar(producto);
        
        String jsonRespuesta = gson.toJson(producto);
        escritoRespuesta.println(jsonRespuesta);
        

   }
    @Override
@SuppressWarnings("empty-statement")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        PrintWriter escritoRespuesta = response.getWriter();
        response.setContentType("application/json;charset=UTF-8");
        
        
        BufferedReader bufRead = request.getReader();
        
        StringBuilder textoJson = new StringBuilder();
        for (String lineaJson = bufRead.readLine();
                lineaJson != null;
               lineaJson = bufRead.readLine()){//iteración 
        
        textoJson.append(lineaJson);
        
    }
        bufRead.close();
       
        System.out.println(">>>>>" + textoJson.toString().toUpperCase());
        
        Gson gson = new Gson();
        Producto producto = gson.fromJson(textoJson.toString(), Producto.class);
        //<System.out.println(">>>>>" + producto.getNombre());
        
        //producto.setNombre(producto.getNombre().toUpperCase());
        //producto.setPrecio("5000 bolivares");
        //si lo usas una vez
        //ServicioProductoSingleton.getInstancia().modificar(producto);
        //si lo usas más veces se guarda
        ServicioProductoSingleton sps = ServicioProductoSingleton.getInstancia();
        Producto p1 = new Producto("Aaah","1000 pavos");
        Producto p2 = new Producto("Eeeh","2000 bolos");
        Producto p3 = new Producto("Iiih","3000 lucas");
        
        //sps.insertar(producto);
        sps.insertar(p1);
        sps.insertar(p2);
        sps.insertar(p3);
        sps.insertar(producto);
        ArrayList<Producto> listaPro =  sps.obtenerTodos();
        Producto listaProductos[] = new Producto[listaPro.size()];
        
        for (int i=0; i< listaPro.size();i++) {
            
            listaProductos[i] = listaPro.get(i);
            i++;
        }
        
        String jsArray = gson.toJson(listaPro);
        String jobj = "";
       /* 
        for (int j = 0; j < listaProductos.length; j++) {
         jobj= gson.toJson(listaProductos[j]);
         jsArray.add(jobj);
      }
*/

      System.out.println(jsArray);
      request.setAttribute("jsArray", jsArray);
        
        //HOLA MUNDO
        
        
        
        
        //String jsonRespuesta = gson.toJson(producto);
        escritoRespuesta.println(jsArray);
        
    }
    @Override
  protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
          throws ServletException, IOException {
      setAccessControlHeaders(resp);
      resp.setStatus(HttpServletResponse.SC_OK);
  }

  private void setAccessControlHeaders(HttpServletResponse resp) {
      resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
      resp.setHeader("Access-Control-Allow-Methods", "GET");
  }
}   



