package com.backend.backend.controllers;

import com.backend.backend.dao.libroDao;
import com.backend.backend.models.categoriaModel;
import com.backend.backend.services.StorageService;
import com.backend.backend.utils.JWTUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.backend.backend.models.librosModel;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class librosController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private libroDao librodao;

    @Autowired
    private JWTUtil jwtUtil;


    /*Obtiene todas los libros*/
    @RequestMapping(value = "api/libros", method = RequestMethod.GET)
    public List<librosModel> getLibros(@RequestHeader(value = "Autorization") String token){

        String userID = jwtUtil.getKey(token);
        if (userID == null){
            return new ArrayList<>();
        }
        return librodao.getLibros();
    }

    /*Obtiene un libro*/

    @RequestMapping(value = "api/libros/{id}")
    public List<librosModel> getLibro(@PathVariable Long id){
       List<librosModel> libro = librodao.getLibro(id);
        return libro;
    }

    /*Registrar libro*/
    @RequestMapping(value = "api/libros", method = RequestMethod.POST)
    public void setlibro(@RequestParam("libro") String libroData, @RequestParam("imagen")MultipartFile image, @RequestParam("archivo")MultipartFile archivo) throws IOException {
        System.out.println(libroData);
        Gson gson = new Gson();
        librosModel libro = gson.fromJson(libroData, librosModel.class);
        Map<String, String> urlM = null;
        Map<String, String> urlM1 = null;
        String urlarchi = null;
        String urlImg = null;
        libro.setImagen(null);
        libro.setArchivo(null);
        if (!image.isEmpty()){

            String path = storageService.store(image);
            String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
            String url = ServletUriComponentsBuilder
                    .fromHttpUrl(host)
                    .path("/media/")
                    .path(path)
                    .toString();
            urlM = Map.of("url", url);
            urlarchi= ServletUriComponentsBuilder
                    .fromHttpUrl(host)
                    .path("/media/")
                    .path(path)
                    .toString();
            libro.setArchivo(ServletUriComponentsBuilder
                    .fromHttpUrl(host)
                    .path("/media/")
                    .path(path)
                    .toString());
        }
        if (archivo.isEmpty()){

            String path = storageService.store(archivo);
            String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
            String url = ServletUriComponentsBuilder
                    .fromHttpUrl(host)
                    .path("/media/")
                    .path(path)
                    .toString();
            urlM = Map.of("url", url);
            urlImg= ServletUriComponentsBuilder
                    .fromHttpUrl(host)
                    .path("/media/")
                    .path(path)
                    .toString();
            libro.setImagen(ServletUriComponentsBuilder
                    .fromHttpUrl(host)
                    .path("/media/")
                    .path(path)
                    .toString());
        }

        System.out.println(libro);

        librodao.postLibro(libro);

    }

    /*Eliminar libro*/
    @RequestMapping(value = "api/libros/{id}", method = RequestMethod.DELETE)
    public void deleteLibro(@PathVariable Long id){
        librodao.deleteLibro(id);

    }

    /*Editar libro*/
    @RequestMapping(value = "api/libros/{id}", method = RequestMethod.PUT)
    public void editLibro(@RequestBody librosModel libro, @PathVariable Long id){
        librodao.editLibro(libro, id);
    }





    @RequestMapping(value = "api/libros1", method = RequestMethod.POST)
    public void setlibro1(@RequestBody librosModel libro){


        librodao.postLibro(libro);

    }
}


