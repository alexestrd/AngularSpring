package com.backend.backend.dao;

import com.backend.backend.models.categoriaModel;

import java.util.List;

public interface categoriaDao {

    void postCategoria(categoriaModel categoria);

    /*Obtiene todas las categorias*/
    List<categoriaModel> getCategorias();


    /*Obtiene una sola categoria*/
    List<categoriaModel> getCategoria(long id);

    void deleteCategoria(Long id);

    void editCategoria(categoriaModel categoria, Long id);
}
