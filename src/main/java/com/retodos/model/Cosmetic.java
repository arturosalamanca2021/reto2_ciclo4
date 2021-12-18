package com.retodos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cosmetics")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cosmetic {

    @Id
    private String reference;
    private String brand;
    private String category;
    private String description;
    private boolean availability = true;
    private Double price;
    private Integer quantity;
    private String photography;

}
