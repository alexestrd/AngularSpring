package com.backend.backend.dao;

import com.backend.backend.controllers.fileContoller;
import com.backend.backend.models.categoriaModel;
import com.backend.backend.models.librosModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class libroDaoImp implements libroDao{

    private fileContoller file;

    @PersistenceContext
    private EntityManager entityManager;


    /*Editar libro*/
    @Override
    public void editLibro(librosModel libro, Long id) {
            librosModel librobuscado = entityManager.find(librosModel.class, id);
                    librobuscado = libro;
            entityManager.merge(librobuscado);
    }


    /*Eliminar libro*/
    @Override
    public void deleteLibro(Long id) {
        librosModel libro = entityManager.find(librosModel.class, id);
        entityManager.remove(libro);

    }


    /*Registrar libro*/
    @Override
    public void postLibro(librosModel libro) {

        entityManager.merge(libro);
    }




    /*Obtener libro*/
    @Override
    public List<librosModel> getLibro(Long id) {
        String idconverter = Long.toString(id);
        String query = "FROM librosModel WHERE id = :id";
        List<librosModel> libro = entityManager.createQuery(query)
                .setParameter("id", id)
                .getResultList();
        return libro;
    }


    /*Obtener libros*/
    @Override
    public List<librosModel> getLibros() {
        String query = "FROM librosModel";
        return entityManager.createQuery(query).getResultList();
    }
}
