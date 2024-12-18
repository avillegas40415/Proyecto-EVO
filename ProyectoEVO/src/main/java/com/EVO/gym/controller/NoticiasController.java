package com.EVO.gym.controller;
import com.EVO.gym.domain.Noticia;
import com.EVO.gym.service.NoticiaService;
import com.EVO.gym.service.impl.NoticiaServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes; //Pruebas guardar

@Controller
@Slf4j
@RequestMapping("/noticias")
public class NoticiasController {
    
    @Autowired
    private NoticiaService noticiaService;
    
    /*@GetMapping("/listado")
    public String inicio(Model model) {
        var membresias = membresiaService.getMembresias(false);
        model.addAttribute("membresias", membresias);
        model.addAttribute("totalMembresias", membresias.size());
        return "/membresias/listado";
    }*/
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var noticias = noticiaService.getNoticias(false);
        model.addAttribute("noticias", noticias);
        model.addAttribute("totalNoticias", noticias.size());
        model.addAttribute("noticia", new Noticia()); // Añadir esta línea
        return "/noticias/listado";
    }
    
    @GetMapping("/nuevo")
    public String noticiaNuevo(Noticia noticia) {
        return "/noticias/modifica";
    }
    
    /*@GetMapping("/modificar/{idMembresia}")
    public String membresiaModificar(Membresia membresia, Model model) {
        membresia = membresiaService.getMembresia(membresia);
        model.addAttribute("membresia", membresia);
        return "/membresia/modifica";
    }*/
    /*
    public String noticiaModificar(@RequestParam("idNoticia") Long idNoticia, Model model) {
        // Crear una instancia de Membresia y asignarle el ID
        Noticia noticia = new Noticia();
        noticia.setIdNoticia(idNoticia);
        // Obtener la noticia por ID usando la instancia de Noticia
        noticia = noticiaService.getNoticia(noticia); 
        model.addAttribute("noticia", noticia);
        return "/noticia/modifica";
    }*/
    
    /*@Autowired
    private FirebaseStorageServiceImp firebaseStorageService;*/
    
    @PostMapping("/guardar")
    public String membresiaGuardar(Noticia noticia){
        noticiaService.save(noticia);
        return "redirect:/noticias/listado";
    }
    
    @GetMapping("/eliminar/{idNoticia}")
    public String membresiaEliminar(Noticia noticia) {
        noticiaService.delete(noticia);
        return "redirect:/noticias/listado";
    }
    /*@GetMapping("/modificar/{idCategoria}")
    public String categoriaModificar(Categoria categoria, Model model) {
        categoria = membresiaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }*/
    
    @GetMapping("/modificar/{idNoticia}")
    public String noticiaModificar(Noticia noticia, Model model) {
        noticia = noticiaService.getNoticia(noticia);
        model.addAttribute("noticias", noticia);
        return "/noticias/modifica";
    }
    
    @GetMapping("/{id}")
    @ResponseBody // Para devolver JSON
    public Noticia getNoticia(@PathVariable Long id) {
        return noticiaService.getNoticiaById(id);
    }
}