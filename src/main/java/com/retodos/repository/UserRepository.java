package com.retodos.repository;

import com.retodos.model.User;
import com.retodos.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository crudInterface;

    public Optional<User> getUser(int id) {
        return crudInterface.findById(id);
    }

    public User create(User user) {
        return crudInterface.save(user);
    }

    public void update(User user) {
        crudInterface.save(user);
    }

    public List<User> listAll() {
        return crudInterface.findAll();
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = crudInterface.findByEmail(email);
        return !usuario.isEmpty();
    }

    public void delete(User user) {
        crudInterface.delete(user);
    }

    public Optional<User> authUser(String email, String password) {
        return crudInterface.findByEmailAndPassword(email, password);
    }
}
