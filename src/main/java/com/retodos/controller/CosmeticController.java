package com.retodos.controller;

import com.retodos.model.Cosmetic;
import com.retodos.services.CosmeticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/cosmetics")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.POST})
public class CosmeticController {

    @Autowired
    private CosmeticService service;

    @GetMapping("/all")
    public List<Cosmetic> listar(){ return service.listAll();}

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetic create(@RequestBody Cosmetic cosmetic) {
        return service.create(cosmetic);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetic update(@RequestBody Cosmetic cosmetic) {
        return service.update(cosmetic);
    }

    @DeleteMapping("/{ref}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("ref") String ref) {
        return service.delete(ref);
    }

    @GetMapping("/{ref}")
    public Optional<Cosmetic> getItemById(@PathVariable("ref") String ref) {
        return service.getCosmetic(ref);
    }
}
