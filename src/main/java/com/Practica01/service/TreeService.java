/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Practica01.service;


import com.Practica01.domain.Tree;
import java.util.List;

public interface TreeService {
    
        //se recupera la lista de categorias de la tabla categoria dentro de un ArrayList
        //solo las activas o todas
    public List<Tree> getTrees(boolean activo);
    
    
        //se obtiene un registro de categorias
        //en un objeto de tipo categoria
        //Si el idcategoria existe.... si no existe es null  
    public Tree getTree(Tree tree);
    
    
        //Se crea un nuevo registro en la tabla Tree
        //Si el objeto Tree NO tiene idCategoria
        //Se actualixa el registro en la tabla categoria
        //Si el objeto Tree tiene un idCategoria
    public void save(Tree tree);
    
    
        //Se elimina el registro en la tabla Tree si
        //el idCategoria existe en la tabla
    public void delete(Tree tree);
    
    
}