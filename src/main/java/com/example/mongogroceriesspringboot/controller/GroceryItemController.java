package com.example.mongogroceriesspringboot.controller;


import com.example.mongogroceriesspringboot.model.GroceryItem;
import com.example.mongogroceriesspringboot.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class GroceryItemController {

    @Autowired
    private GroceryItemService groceryItemService;

    @PostMapping
    public GroceryItem createGroceryItem(@RequestBody GroceryItem groceryItem) {
        return groceryItemService.createGroceryItem(groceryItem);
    }

    @GetMapping
    public List<GroceryItem> getAllGroceryItem() {
        return groceryItemService.getAllGroceryItems();
    }

    @GetMapping("/{name}")
    public GroceryItem getGroceryItemByName(@PathVariable String name) {
        return groceryItemService.getGroceryItemByName(name);
    }

    @PutMapping("/{name}/category")
    public  GroceryItem updateGroceryItemByName(@PathVariable String name, @RequestBody GroceryItem item) {
        return groceryItemService.updateGroceryItem(name, item);
    }

    @DeleteMapping("/{id}")
    public void deleteGroceryItem(@PathVariable String id) {
        groceryItemService.deleteGroceryItem(id);
    }
}
