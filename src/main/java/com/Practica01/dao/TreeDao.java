
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Practica01.dao;

import com.Practica01.domain.Tree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeDao 
        extends JpaRepository<Tree, Long> {
    
}