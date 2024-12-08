package com.EVO.gym.controller;

import com.EVO.gym.domain.Producto;
import com.EVO.gym.service.ProductoService;
import com.EVO.gym.service.impl.ProductoServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes; //Pruebas guardar

@Controller
@Slf4j
@RequestMapping("/productosAdmin")
public class ProductosController {
    
    @Autowired
    private ProductoService productoService;
    
    /*@GetMapping("/listado")
    public String inicio(Model model) {
        var membresias = membresiaService.getMembresias(false);
        model.addAttribute("membresias", membresias);
        model.addAttribute("totalMembresias", membresias.size());
        return "/membresias/listado";
    }*/
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("producto", new Producto()); // Añadir esta línea
        return "/productos/listado";
    }
    
    @GetMapping("/nuevo")
    public String productoNuevo(Producto producto) {
        return "/productos/modifica";
    }

    
    /*@GetMapping("/modificar/{idMembresia}")
    public String membresiaModificar(Membresia membresia, Model model) {
        membresia = membresiaService.getMembresia(membresia);
        model.addAttribute("membresia", membresia);
        return "/membresia/modifica";
    }*/
    
    public String productoModificar(@RequestParam("idProducto") Long idProducto, Model model) {
        // Crear una instancia de Producto y asignarle el ID
        Producto producto = new Producto();
        producto.setIdProducto(idProducto);

        // Obtener la producto por ID usando la instancia de Producto
        producto = productoService.getProducto(producto); 

        model.addAttribute("producto", producto);
        return "/productos/modifica";
    }
    
    /*@Autowired
    private FirebaseStorageServiceImp firebaseStorageService;*/
    
    @PostMapping("/guardar")
    public String productoGuardar(Producto producto){

        productoService.save(producto);
        return "redirect:/productos/listado";
    }


    @GetMapping("/eliminar/{idProducto}")
    public String productoEliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/productosAdmin/listado";
    }

    /*@GetMapping("/modificar/{idCategoria}")
    public String categoriaModificar(Categoria categoria, Model model) {
        categoria = membresiaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }*/
    
}
