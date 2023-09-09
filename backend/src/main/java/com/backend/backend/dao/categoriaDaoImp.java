package com.backend.backend.dao;

import com.backend.backend.models.categoriaModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class categoriaDaoImp implements categoriaDao {

    @PersistenceContext
    private EntityManager entityManager;

    /*Registrar categoria*/
    @Override
    public void postCategoria(categoriaModel categoria) {
        entityManager.merge(categoria);
    }

    /*Obtiene todas las categorias*/
    @Override
    public List<categoriaModel> getCategorias() {
        String query = "FROM categoriaModel";
        return entityManager.createQuery(query).getResultList();
    }


    /*Obtiene una sola categoria*/
    @Override
    public List<categoriaModel> getCategoria(long id) {
        String idconverter = Long.toString(id);
        String query = "FROM categoriaModel WHERE id_categoria = :id_categoria";
        List<categoriaModel> list = entityManager.createQuery(query)
                .setParameter("id_categoria", idconverter)
                .getResultList();

        return list;
    }

    /*Eliminando categoria*/
    @Override
    public void deleteCategoria(Long id) {
        categoriaModel categoria = entityManager.find(categoriaModel.class, id);
        entityManager.remove(categoria);
    }

    /*Editando categoria*/
    @Override
    public void editCategoria(categoriaModel categoria, Long id) {
        categoriaModel categoriabuscada = entityManager.find(categoriaModel.class, id);
        categoriabuscada = categoria;
        entityManager.merge(categoriabuscada);
    }
}
