package com.EVO.gym.controller;

import com.EVO.gym.domain.Categoria;
import com.EVO.gym.service.CategoriaService;
import com.EVO.gym.domain.Producto;
import com.EVO.gym.service.ProductoService;
import java.util.List;
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
@RequestMapping("/productos")
public class ProductosController {
  
    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        
        model.addAttribute("totalProductos",productos.size());
        return "/productos/listado";
    }
    
    @PostMapping("/guardar")
    public String productoGuardar(Producto producto){
        productoService.save(producto);
        return "redirect:/productos/listado";
    }
    
}
