package com.backend.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "libros")
public class librosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "resumen")
    private String resumen;

    @Getter @Setter @Column(name = "autor")
    private String autor;

    @Getter @Setter @Column(name = "editorial")
    private String editorial;

    @Getter @Setter @Column(name = "imagen")
    private String imagen;

    @Getter @Setter @Column(name = "archivo")
    private String archivo;

    @Getter @Setter @Column(name = "id_categoria")
    private String id_categoria;


}

