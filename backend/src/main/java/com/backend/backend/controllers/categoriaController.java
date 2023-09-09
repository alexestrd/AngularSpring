package com.backend.backend.controllers;

import com.backend.backend.dao.categoriaDao;
import com.backend.backend.models.categoriaModel;
import org.springframework.beans.factory.annotation.Autowired;
import com.backend.backend.utils.JWTUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class categoriaController {

    @Autowired
    private categoriaDao CategoriaDao;

    @Autowired
    private JWTUtil jwtUtil;


    /*Obtiene todas las categorias*/
    @RequestMapping(value = "api/categoria", method = RequestMethod.GET)
    public List<categoriaModel> getCategorias(@RequestHeader(value = "Autorization") String token){

        String userID = jwtUtil.getKey(token);
        if (userID == null){
            return new ArrayList<>();
        }
        return CategoriaDao.getCategorias();
    }

    /*Obtiene una categoria*/

    @RequestMapping(value = "api/categoria/{id}")
    public List<categoriaModel> getCategoria(@PathVariable Long id){
        List<categoriaModel> categoria = CategoriaDao.getCategoria(id);
        return categoria;
    }

    /*Editar categoria*/
    @RequestMapping(value = "api/categoria", method = RequestMethod.POST)
    public void  setcategoria(@RequestBody categoriaModel categoria){

        CategoriaDao.postCategoria(categoria);

    }

    /*Eliminar categoria*/
    @RequestMapping(value = "api/categoria/{id}", method = RequestMethod.DELETE)
    public void deleteCategoria(@PathVariable Long id){
        CategoriaDao.deleteCategoria(id);

    }

    /*Editar categoria*/
    @RequestMapping(value = "api/categoria/{id}", method = RequestMethod.PUT)
    public void editCategoria(@RequestBody categoriaModel categoria, @PathVariable Long id){
        CategoriaDao.editCategoria(categoria, id);
    }
}
