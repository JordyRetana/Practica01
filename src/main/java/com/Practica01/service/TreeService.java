package com.Practica01.service;

import com.Practica01.domain.Tree;
import java.util.List;

public interface TreeService {
    

    public List<Tree> getArboles(boolean activo);
    

    public Tree getArbol(Tree arbol);
    

    public void save(Tree arbol);

    public void delete(Tree arbol);
}
