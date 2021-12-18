package com.retodos;

import com.retodos.model.Cosmetic;
import com.retodos.model.User;
import com.retodos.repository.crud.CosmeticCrudRepository;
import com.retodos.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RetodosApplication implements CommandLineRunner {

	@Autowired
	private UserCrudRepository userRepo;

	@Autowired
	private CosmeticCrudRepository cosmRepo;

	public static void main(String[] args) {
		SpringApplication.run(RetodosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cosmRepo.deleteAll();
		cosmRepo.saveAll(List.of(
			new Cosmetic("123-ABC", "MARCA 1", "CATEGORIA 1", "DESCRIPTION", true, 1500d, 100, ""),
			new Cosmetic("123-CDE", "MARCA 2", "CATEGORIA 2", "DESCRIPTION2", true, 2500d, 120, "")
		));

		userRepo.deleteAll();
		userRepo.saveAll(List.of(
			new User(1, "1018460767", "JUANA LA LOCA", "CRA 123", "311211211", "juan@gmail.com", "demo123", "Zona 1", "ADM"),
			new User(2, "1018460768", "JUANA LA LOCA2", "CRA 1233", "311211212", "juana2@gmail.com", "Demo1234", "Zona 2", "ASM")
		));
		System.out.println("Listado de usuarios");
		userRepo.findAll().forEach(System.out::println);
		cosmRepo.findAll().forEach(System.out::println);
	}
}
