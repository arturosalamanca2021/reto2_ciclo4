package com.retodos.services;

import com.retodos.model.Cosmetic;
import com.retodos.repository.CosmeticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CosmeticService {
    @Autowired
    private CosmeticRepository repository;

    public Optional<Cosmetic> getCosmetic(String ref) {
        return repository.getCosmetic(ref);
    }

    /**
     *
     * @return
     */
    public List<Cosmetic> listAll() {
        return repository.listAll();
    }

    /**
     *
     * @param cosmetic
     * @return
     */
    public Cosmetic create(Cosmetic cosmetic) {
        if (cosmetic.getReference() == null) {
            return cosmetic;
        } else {
            Optional<Cosmetic> e = repository.getCosmetic(cosmetic.getReference());
            if (e.isEmpty()) {
                if (cosmetic.getReference() != null) {
                    return repository.create(cosmetic);
                } else {
                    return cosmetic;
                }
            } else {
                return cosmetic;
            }
        }
    }

    /**
     *
     * @param cosmetic
     * @return
     */
    public Cosmetic update(Cosmetic cosmetic) {

        if (cosmetic.getReference() != null) {
            Optional<Cosmetic> cosmeticDb = repository.getCosmetic(cosmetic.getReference());
            if (!cosmeticDb.isEmpty()) {
                if (cosmetic.getReference() != null) {
                    cosmeticDb.get().setReference(cosmetic.getReference());
                }
                if (cosmetic.getBrand() != null) {
                    cosmeticDb.get().setBrand(cosmetic.getBrand());
                }
                if (cosmetic.getCategory() != null) {
                    cosmeticDb.get().setCategory(cosmetic.getCategory());
                }

                if (cosmetic.getDescription() != null) {
                    cosmeticDb.get().setDescription(cosmetic.getDescription());
                }

                if (cosmetic.getPrice() != null) {
                    cosmeticDb.get().setPrice(cosmetic.getPrice());
                }
                if (cosmetic.getQuantity() != null) {
                    cosmeticDb.get().setQuantity(cosmetic.getQuantity());
                }
                if (cosmetic.getPhotography() != null) {
                    cosmeticDb.get().setPhotography(cosmetic.getPhotography());
                }

                repository.update(cosmeticDb.get());
                return cosmeticDb.get();
            } else {
                return cosmetic;
            }
        } else {
            return cosmetic;
        }
    }

    /**
     *
     * @param ref
     * @return
     */
    public boolean delete(String ref) {
        return getCosmetic(ref).map(cosmetic -> {
            repository.delete(cosmetic);
            return true;
        }).orElse(false);
    }
}
