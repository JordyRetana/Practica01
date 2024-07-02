package com.Practica01.service.impl;

import com.Practica01.domain.Tree;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Practica01.dao.TreeDao;
import com.Practica01.service.TreeService;

@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeDao treeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tree> getArboles(boolean activo) {
        var lista = treeDao.findAll();

        if (activo) {
            lista.removeIf(c -> !c.isActivo()); 
        }

        return lista;
    }

    @Override
    @Transactional
    public Tree getArbol(Tree arbol) {
        return treeDao.findById(arbol.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Tree arbol) {
        treeDao.save(arbol);
    }

    @Override
    @Transactional
    public void delete(Tree arbol) {
        treeDao.delete(arbol);
    }
}
