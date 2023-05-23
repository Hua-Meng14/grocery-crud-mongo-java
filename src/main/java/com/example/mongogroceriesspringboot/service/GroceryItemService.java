package com.example.mongogroceriesspringboot.service;

import com.example.mongogroceriesspringboot.model.GroceryItem;
import com.example.mongogroceriesspringboot.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemService {
    private final ItemRepository groceryItemRepo;

    @Autowired
    public GroceryItemService(ItemRepository groceryItemRepo) {
        this.groceryItemRepo = groceryItemRepo;
    }

    public List<GroceryItem> getAllGroceryItems() {
        try {
            return groceryItemRepo.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while retrieving grocery items: " + e.getMessage());
        }
    }

    public GroceryItem getGroceryItemByName(String name) {
        try {
            Optional<GroceryItem> optionalItem = Optional.ofNullable(groceryItemRepo.findItemByName(name));
            if (optionalItem.isPresent()) {
                return optionalItem.get();
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grocery item not found for name: " + name);
            }
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while retrieving grocery item: " + e);
        }
    }

    public GroceryItem createGroceryItem(GroceryItem item) {
        try {
            return groceryItemRepo.save(item);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while creating grocery item: ", e);
        }
    }

    public GroceryItem updateGroceryItem(String name, GroceryItem updatedItem) {
        try {
            Optional<GroceryItem> optionalItem = Optional.ofNullable(groceryItemRepo.findItemByName(name));
            if (optionalItem.isPresent()) {
                GroceryItem existingItem = optionalItem.get();
                existingItem.setName(updatedItem.getName());
                existingItem.setCategory(updatedItem.getCategory());
                existingItem.setQuantity(updatedItem.getQuantity());
                return groceryItemRepo.save(existingItem);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grocery item not found for name: " + name);
            }
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while updating grocery item.", e);
        }
    }

    public void deleteGroceryItem(String name) {

        try {
            Optional<GroceryItem> optionalItem = Optional.ofNullable(groceryItemRepo.findItemByName(name));
            if (optionalItem.isPresent()) {
                GroceryItem existingItem = optionalItem.get();
                groceryItemRepo.delete(existingItem);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Grocery item not found for name: " + name);
            }
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while deleting grocery item: " + e);
        }
    }


}
