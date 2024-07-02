/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Practica01.service.impl;



import com.Practica01.domain.Tree;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Practica01.dao.TreeDao;
import com.Practica01.service.TreeService;

@Service
public class TreeServiceImpl 
        implements TreeService {

    @Autowired
    private TreeDao treeDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Tree> getTrees(boolean activo) {
        var lista = treeDao.findAll();
        
        if (activo) { //solo activos
            lista.removeIf(c ->!c.isActivo()); //remueve si no está activo
        }
        
        return lista;
    }

    @Override
     @Transactional
    public Tree getTree(Tree tree) {
        return treeDao.findById(tree.getIdarbol()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Tree tree) {
        treeDao.save(tree);
    }

    @Override
    @Transactional
    public void delete(Tree tree) {
        treeDao.delete(tree);
    }
    
}