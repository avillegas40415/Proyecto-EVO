package com.EVO.gym.controller;

import com.EVO.gym.domain.Beneficio;
import com.EVO.gym.domain.Membresia;
import com.EVO.gym.service.MembresiaService;
import com.EVO.gym.service.impl.MembresiaServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
   
    
    ////PRUEBAS DE GUARDAR CON BENEFICIOS
    /*
    @PostMapping("/guardar")
    public String membresiaGuardar(Membresia membresia){

        membresiaService.save(membresia);
        return "redirect:/membresias/listado";
    }*/
    /*@PostMapping("/guardar")
    public String membresiaGuardar(@ModelAttribute("membresia") Membresia membresia, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Manejar errores de validación
        } else {
            // Obtener la lista de beneficios del formulario
            List<Beneficio> beneficios = membresia.getBeneficios();

            // Iterar sobre la lista de beneficios y asociarlos a la membresía
            if (beneficios != null) {
                for (Beneficio beneficio : beneficios) {
                    beneficio.setMembresia(membresia);
                }
            }

            // Guardar la membresía con sus beneficios
            membresiaService.save(membresia);
        }
        return "redirect:/membresias/listado"; // Redirigir a la página de listado de membresías
    }*/
    @Autowired
    private HttpServletRequest request;
    
    /*@PostMapping("/guardar")
    public String membresiaGuardar(@ModelAttribute("membresia") Membresia membresia, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Manejar errores de validación
        } else {
            // Obtener la lista de beneficios del formulario
            List<Beneficio> beneficios = membresia.getBeneficios();

            // Crear una nueva lista de beneficios si está vacía
            if (beneficios == null) {
                beneficios = new ArrayList<>();
                membresia.setBeneficios(beneficios);
            }

            // Iterar sobre la lista de beneficios y asociarlos a la membresía
            for (int i = 0; i < beneficios.size(); i++) {
                String descripcion = request.getParameter("beneficios[" + i + "].descripcion");
                if (descripcion != null && !descripcion.isEmpty()) {
                    Beneficio beneficio = beneficios.get(i);
                    if (beneficio == null) {
                        beneficio = new Beneficio();
                        beneficios.add(beneficio);
                    }
                    beneficio.setDescripcion(descripcion);
                    beneficio.setMembresia(membresia);
                }
            }

            // Guardar la membresía con sus beneficios
            membresiaService.save(membresia);
        }
        return "redirect:/membresias/listado";
    }*/
    
    @PostMapping("/guardar")
public String membresiaGuardar(@ModelAttribute("membresia") Membresia membresia, BindingResult result, Model model) {
    if (result.hasErrors()) {
        // Manejar errores de validación
    } else {
        // Obtener la lista de beneficios del formulario
        List<Beneficio> beneficios = membresia.getBeneficios();

        // Crear una nueva lista de beneficios si está vacía
        if (beneficios == null) {
            beneficios = new ArrayList<>();
            membresia.setBeneficios(beneficios);
        }
        
        // Eliminar los beneficios marcados para eliminar
        for (int i = beneficios.size() - 1; i >= 0; i--) { // Iterar en orden inverso para evitar problemas al eliminar elementos
            if ("true".equals(request.getParameter("beneficios[" + i + "].eliminar"))) {
                beneficios.remove(i);
            }
        }

        // Iterar sobre la lista de beneficios y asociarlos a la membresía
        for (int i = 0; i < beneficios.size(); i++) {
            Beneficio beneficio = beneficios.get(i);
            if (beneficio == null) {
                beneficio = new Beneficio();
                beneficios.add(beneficio);
            }
            // Obtener la descripción del beneficio del formulario (esto ya lo hace Thymeleaf con th:field)
            // No necesitas usar request.getParameter() aquí
            beneficio.setMembresia(membresia); 
        }

        // Guardar la membresía con sus beneficios
        membresiaService.save(membresia);
    }
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
