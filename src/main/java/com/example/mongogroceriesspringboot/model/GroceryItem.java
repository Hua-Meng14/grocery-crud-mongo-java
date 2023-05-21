package com.example.mongogroceriesspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("groceryitems")
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
public class GroceryItem {

    @Id
    private String id;
    private String name;
    private int quantity;
    private String category;

    public GroceryItem() {
        // Default constructor with no arguments
    }

    public GroceryItem(String id ,String name, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }

}