package com.EVO.gym.controller;

import com.EVO.gym.domain.Membresia;
import com.EVO.gym.domain.Noticia;
import com.EVO.gym.domain.Producto;
import com.EVO.gym.service.MembresiaService;
import com.EVO.gym.service.NoticiaService;
import com.EVO.gym.service.ProductoService;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class SubpaginasController {
    
    @Autowired
    private MembresiaService membresiaService;
    @Autowired
    private NoticiaService noticiaService;
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/index")
    public String index(Model model) {
        List<Noticia> noticias = noticiaService.getNoticias(true); // Obtener las membresías
        noticias.sort(Comparator.comparing(Noticia::getIdNoticia).reversed()); // Ordenar por idNoticia descendente
        model.addAttribute("noticias", noticias); // Agregarlas al modelo
        return "index"; // Retorna el nombre de la vista (index.html)
    }
    
    @GetMapping("/nosotros")
    public String nosotros() {
        return "nosotros"; // Retorna el nombre de la vista (nosotros.html)
    }
    
    @GetMapping("/gimnasio")
    public String gimnasio() {
        return "gimnasio"; // Retorna el nombre de la vista (nosotros.html)
    }
    
    /*
    @GetMapping("/planes")
    public String planes() {
        return "planes"; // Retorna el nombre de la vista (nosotros.html)
    }*/
    @GetMapping("/planes")
    public String planes(Model model) {
        List<Membresia> membresias = membresiaService.getMembresias(true); // Obtener las membresías
        model.addAttribute("membresias", membresias); // Agregarlas al modelo
        return "planes"; // Retornar el nombre de la vista
    }
    
    @GetMapping("/productos")
    public String productos(Model model) {
        List<Producto> productos = productoService.getProductos(true); // Obtener las membresías
        model.addAttribute("productos", productos); // Agregarlas al modelo
        return "productos"; // Retorna el nombre de la vista (nosotros.html)
    }
    
    @GetMapping("/contacto")
    public String contacto() {
        return "contacto"; // Retorna el nombre de la vista (nosotros.html)
    }
    
    @GetMapping("/login")
    public String login() {
        return "login"; // Retorna el nombre de la vista (login.html)
    }
    
    @GetMapping("/perfil")
    public String perfil() {
        return "perfil"; // Retorna el nombre de la vista (perfil.html)
    }
    
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Retorna el nombre de la vista (dashboard.html)
    }
    
    /*@GetMapping("/membresias")
    public String membresias() {
        return "membresias"; // Retorna el nombre de la vista (membresias.html)
    }*/
}
