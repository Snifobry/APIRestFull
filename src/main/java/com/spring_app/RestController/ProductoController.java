package com.spring_app.RestController;

import com.spring_app.Entidad.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class ProductoController {
    private List<Producto> productos;

    public ProductoController() {
        productos = new ArrayList<>();
        productos.add(new Producto(1,"Goku ", 1,48.20));
        productos.add(new Producto(2,"Broly", 1,65));
        productos.add(new Producto(3,"Gogeta", 1,25.99));
    }

    @GetMapping("/api/productos")
    public List<Producto> listarProductos() {
        return productos;
    }

    @GetMapping("/api/productos/{id}")
    //@Pathvariable hace q la ide de ruta /{id} se injecte en el controllador para buscar por id
    //despues del path donde dice "int id" esto no debe cambiar asi esta hecho no cambies Snifo xfa
    public Producto buscarProducto(@PathVariable int id) {
        for (Producto producto: productos) {
            if(producto.getIdProducto()==id){
                return producto;
            }
        }
        return null;
    }
    
    @PostMapping("/registrarProductos")
    //@RequestBOdy lo que nos dice es el cuerpo de la solicitud enviamos un documento Json
    public Producto crearProducto(@RequestBody Producto producto){
        producto.setIdProducto(productos.size()+1);
        productos.add(producto);
        return producto;
    }

    @PutMapping("/actualizarProducto/{id}")
    public Producto actualizarProducto(@PathVariable int id, @RequestBody Producto producto){
        for (Producto productoExistente: productos) {
            if(productoExistente.getIdProducto()==id){
                productoExistente.setDescripcion(producto.getDescripcion());
                productoExistente.setCantidad(producto.getCantidad());
                productoExistente.setPrecio(producto.getPrecio());
                return productoExistente;
            }
        }
        return null;
    }

    @DeleteMapping("/api/eliminarProducto/{id}")
    public void eliminarProducto(@PathVariable int id){
        for (Producto producto: productos) {
            if(producto.getIdProducto()==id){
                productos.remove(producto);
                break;
            }
        }
    }
}
