package com.retodos.repository.crud;

import com.retodos.model.Cosmetic;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CosmeticCrudRepository extends MongoRepository<Cosmetic, Integer> {
    Optional<Cosmetic> findByReference(String ref);
}
