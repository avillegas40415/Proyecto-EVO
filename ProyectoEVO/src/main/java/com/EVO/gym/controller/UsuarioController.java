package com.EVO.gym.controller;

import com.EVO.gym.domain.Usuario;
import com.EVO.gym.service.UsuarioService;
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
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    /*@GetMapping("/listado")
    public String inicio(Model model) {
        var membresias = membresiaService.getMembresias(false);
        model.addAttribute("membresias", membresias);
        model.addAttribute("totalMembresias", membresias.size());
        return "/membresias/listado";
    }*/
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var usuarios = usuarioService.getUsuarios(false);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalusuarios", usuarios.size());
        model.addAttribute("usuarios", new Usuario()); // Añadir esta línea
        return "/usuarios/listado";
    }
    
    @GetMapping("/nuevo")
    public String membresiaNuevo(Usuario usuarios) {
        return "/usuarios/modifica";
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
    public String usuarioGuardar(Usuario usuario){
        usuarioService.save(usuario,false);
        return "redirect:/noticias/listado";
    }


    @GetMapping("/eliminar/{idUsuario}")
    public String usuarioEliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuarios/listado";
    }

    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuarios", usuario);
        return "/usuarios/modifica";
    }
    
}
