package com.EVO.gym.controller;

import com.EVO.gym.domain.Membresia;
import com.EVO.gym.service.MembresiaService;
import com.EVO.gym.service.impl.MembresiaServiceImp;
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
@Slf4j
@RequestMapping("/membresias")
public class MembresiasController {
    
    @Autowired
    private MembresiaService membresiaService;
    
    /*@GetMapping("/listado")
    public String inicio(Model model) {
        var membresias = membresiaService.getMembresias(false);
        model.addAttribute("membresias", membresias);
        model.addAttribute("totalMembresias", membresias.size());
        return "/membresias/listado";
    }*/
    
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var membresias = membresiaService.getMembresias(false);
        model.addAttribute("membresias", membresias);
        model.addAttribute("totalMembresias", membresias.size());
        model.addAttribute("membresia", new Membresia()); // Añadir esta línea
        return "/membresias/listado";
    }
    
    @GetMapping("/nuevo")
    public String membresiaNuevo(Membresia membresia) {
        return "/membresias/modifica";
    }

    
    /*@GetMapping("/modificar/{idMembresia}")
    public String membresiaModificar(Membresia membresia, Model model) {
        membresia = membresiaService.getMembresia(membresia);
        model.addAttribute("membresia", membresia);
        return "/membresia/modifica";
    }*/
    
    /*public String membresiaModificar(@RequestParam("idMembresia") Long idMembresia, Model model) {
        // Crear una instancia de Membresia y asignarle el ID
        Membresia membresia = new Membresia();
        membresia.setIdMembresia(idMembresia);

        // Obtener la membresía por ID usando la instancia de Membresia
        membresia = membresiaService.getMembresia(membresia); 

        model.addAttribute("membresia", membresia);
        return "/membresia/modifica";
    }*/
    
    /*@Autowired
    private FirebaseStorageServiceImp firebaseStorageService;*/
    
    @PostMapping("/guardar")
    public String membresiaGuardar(Membresia membresia){

        membresiaService.save(membresia);
        return "redirect:/membresias/listado";
    }


    @GetMapping("/eliminar/{idMembresia}")
    public String membresiaEliminar(Membresia membresia) {
        membresiaService.delete(membresia);
        return "redirect:/membresias/listado";
    }

    @GetMapping("/modificar/{idMembresia}")
    public String categoriaModificar(Membresia membresia, Model model) {
        membresia = membresiaService.getMembresia(membresia);
        model.addAttribute("membresias", membresia);
        return "/membresias/modifica";
    }
    
}
