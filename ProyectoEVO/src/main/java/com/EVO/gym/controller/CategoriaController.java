package com.EVO.gym.controller;

import com.EVO.gym.domain.Categoria;
import com.EVO.gym.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/categorias")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        return "/categorias/listado"; //Cambiado para hacer pruebas
    }
    
    @GetMapping("/nuevo")
    public String categoriaNuevo(Categoria categoria) {
        return "/categorias/modifica";
    }

    
    @PostMapping("/guardar")
    public String categoriaGuardar(Categoria categoria){

        categoriaService.save(categoria);
        return "redirect:/categorias/listado";
    }

    /*
    @GetMapping("/eliminar/{idCategoria}")
    public String categoriaEliminar(Categoria categoria) {
        categoriaService.delete(categoria);
        return "redirect:/categorias/listado";
    }*/
    
     @GetMapping("/eliminar/{idCategoria}")
    public String categoriaEliminar(@PathVariable Long idCategoria, RedirectAttributes attributes) {
        Categoria categoria = categoriaService.getCategoria(idCategoria);
        if (categoriaService.tieneProductosAsociados(categoria)) { // Verificar si hay productos asociados
            attributes.addFlashAttribute("error", "No se puede eliminar la categoría porque tiene productos asociados.");
            
        } else {
            categoriaService.delete(categoria);
            attributes.addFlashAttribute("success", "Categoría eliminada correctamente.");
        }
        return "redirect:/categorias/listado";
    }

    @GetMapping("/modificar/{idCategoria}")
    public String categoriaModificar(Categoria categorias, Model model) {
        categorias = categoriaService.getCategoria(categorias);
        model.addAttribute("categorias", categorias);
        return "/categorias/modifica";
    }
}