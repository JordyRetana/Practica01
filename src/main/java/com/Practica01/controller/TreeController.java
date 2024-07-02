package com.Practica01.controller;

import com.Practica01.domain.Tree;
import com.Practica01.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.Practica01.service.TreeService;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/tree")
public class TreeController {

    @Autowired
    private TreeService treeService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = treeService.getArboles(false);
        model.addAttribute("arboles", lista);
        model.addAttribute("totalArboles", lista.size());

        return "/tree/listado";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Tree arbol,
            @RequestParam("imagenFile") MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            treeService.save(arbol);
            String rutaImagen
                    = firebaseStorageService.cargaImagen(imagenFile,
                            "tree",
                            arbol.getId());
            arbol.setRutaImagen(rutaImagen);
        }
        treeService.save(arbol);

        return "redirect:/tree/listado";
    }

    @GetMapping("/eliminar/{id_arbol}")
    public String eliminar(@PathVariable("id_arbol") long id_arbol) {
        Tree arbol = new Tree();
        arbol.setId(id_arbol);
        treeService.delete(arbol);

        return "redirect:/tree/listado";
    }

    @GetMapping("/modificar/{id_arbol}")
    public String modificar(@PathVariable("id_arbol") long id_arbol, Model model) {
        Tree arbol = new Tree();
        arbol.setId(id_arbol);
        arbol = treeService.getArbol(arbol);
        model.addAttribute("arbol", arbol);

        return "tree/modificar"; 
    }
}
