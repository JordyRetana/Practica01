/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

@Controller
@RequestMapping("/arboles")
public class TreeController {
    
    @Autowired
    private TreeService treeService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = treeService.getTrees(false);
        model.addAttribute("arboles",lista);
        model.addAttribute("totalarboles",lista.size());
        
        return "/arboles/listado";
    }
    
 @Autowired
 private FirebaseStorageService FirebaseStorageService;
 
 
 @PostMapping("/guardar")
 public String guardar(Tree tree,
        @RequestParam("imagenFile")MultipartFile imagenFile){
    
    if (!imagenFile.isEmpty()){
        treeService.save(tree);
        String rutaImagen=
                FirebaseStorageService.cargaImagen(imagenFile,
                        "arboles",
                        tree.getIdarbol());
        tree.setRutaImagen(rutaImagen);
    }
    treeService.save(tree);
    

     
    return "redirect:/arboles/listado";
 }
 
 @GetMapping("/eliminar/{idarbol}")
 public String eliminar (Tree tree){
    treeService.delete(tree); 
     
    return "redirect:/arboles/listado";

 }
 
@GetMapping("/modificar/{idarbol}")
    public String modificar(Tree tree,Model model){
        tree = treeService.getTree(tree);
        model.addAttribute("arboles", tree);
        
        return "/arboles/modifica";
    }


}