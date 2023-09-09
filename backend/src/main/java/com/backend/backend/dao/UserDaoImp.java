package com.backend.backend.dao;

import com.backend.backend.models.UserModel;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    /*Obtine Todos los usuarios*/
    @Override
    public List<UserModel> getUsers() {
        String query = "FROM UserModel";
        return entityManager.createQuery(query).getResultList();

    }

    /*Elimina un usuario*/
    @Override
    public void deleteUser(Long id) {
        UserModel user = entityManager.find(UserModel.class, id);
        entityManager.remove(user);
    }

    /*Obtener un usuario*/
    @Override
    public UserModel getUser(Long id) {
        return null;
    }

    /*Registra un Usuario*/
    @Override
    public void postUser(UserModel user) {
        entityManager.merge(user);
    }

    /*Login usuario*/
    @Override
    public UserModel obtenerUser(UserModel user) {
        String query = "FROM UserModel WHERE email = :email";
        List<UserModel> list = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();

        if(list.isEmpty()){
            return null;
        }

        String passwordHashed = list.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
         if (argon2.verify(passwordHashed, user.getPassword())){
             return list.get(0);
        }
        return null;
    }


}
