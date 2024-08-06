package com.spring_app.RestController;

import com.spring_app.Entidad.Producto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return productos;
    }


}
