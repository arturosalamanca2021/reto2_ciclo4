package com.retodos.repository;

import com.retodos.model.Cosmetic;
import com.retodos.model.User;
import com.retodos.repository.crud.CosmeticCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CosmeticRepository {
    @Autowired
    private CosmeticCrudRepository crudInterface;

    public Optional<Cosmetic> getCosmetic(String ref) {
        return crudInterface.findByReference(ref);
    }

    public Cosmetic create(Cosmetic cosmetic) {
        return crudInterface.save(cosmetic);
    }

    public void update(Cosmetic cosmetic) {
        crudInterface.save(cosmetic);
    }

    public List<Cosmetic> listAll() {
        return crudInterface.findAll();
    }

    public void delete(Cosmetic cosmetic) {
        crudInterface.delete(cosmetic);
    }
}
