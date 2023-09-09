package com.backend.backend.dao;

import com.backend.backend.models.categoriaModel;
import com.backend.backend.models.librosModel;

import java.util.List;

public interface libroDao {
    void editLibro(librosModel libro, Long id);

    void deleteLibro(Long id);

    void postLibro(librosModel libro);

    List<librosModel> getLibro(Long id);

    List<librosModel> getLibros();
}
