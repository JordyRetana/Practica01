package com.Practica01.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data // sets y gets
@Entity
@Table(name = "arbol") // nombrar la tabla
public class Tree {
    
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbol")
    private long id;
    private String nombreComún;
    private String tipoFlor;
    private String durezaMadera;
    private String otros;
    private String rutaImagen;
    private boolean activo;
}
