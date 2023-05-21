package com.example.mongogroceriesspringboot;

import com.example.mongogroceriesspringboot.model.GroceryItem;
import com.example.mongogroceriesspringboot.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

class MongoGroceriesSpringbootApplicationTests {

    @Mock
    private ItemRepository itemRepository;

    private MongoGroceriesSpringbootApplication mongoGroceriesApp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mongoGroceriesApp = new MongoGroceriesSpringbootApplication();
        mongoGroceriesApp.groceryItemRepo = itemRepository;
    }

    @Test
    void testCreateGroceryItems() {
        GroceryItem item1 = new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks");
        GroceryItem item2 = new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets");
        List<GroceryItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        when(itemRepository.saveAll(items)).thenReturn(items);

        mongoGroceriesApp.createGroceryItems();

        verify(itemRepository, times(1)).saveAll(items);
    }

    @Test
    void testShowAllGroceryItemByName() {
        GroceryItem item1 = new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks");
        GroceryItem item2 = new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets");
        List<GroceryItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        when(itemRepository.findAll()).thenReturn(items);

        mongoGroceriesApp.showAllGroceryItemByName();

        verify(itemRepository, times(1)).findAll();
    }

    @Test
    void testGetGroceryItemByName() {
        String itemName = "Whole Wheat Biscuit";
        GroceryItem item = new GroceryItem(itemName, "Whole Wheat Biscuit", 5, "snacks");

        when(itemRepository.findItemByName(itemName)).thenReturn(item);

        mongoGroceriesApp.getGroceryItemByName(itemName);

        verify(itemRepository, times(1)).findItemByName(itemName);
    }

    @Test
    void testGetItemByCategory() {
        String category = "millets";
        GroceryItem item1 = new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, category);
        GroceryItem item2 = new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, category);
        List<GroceryItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        when(itemRepository.findAllByCategory(category)).thenReturn(items);

        mongoGroceriesApp.getItemByCategory(category);

        verify(itemRepository, times(1)).findAllByCategory(category);
    }

    @Test
    void testFindCountOfGroceryItems() {
        long itemCount = 5L;

        when(itemRepository.count()).thenReturn(itemCount);

        mongoGroceriesApp.findCountOfGroceryItems();

        verify(itemRepository, times(1)).count();
    }

    @Test
    void testUpdateCategoryName() {
        String category = "snacks";
        String newCategory = "munchies";
        GroceryItem item1 = new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, category);
        GroceryItem item2 = new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, category);
        List<GroceryItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        when(itemRepository.findAllByCategory(category)).thenReturn(items);
        when(itemRepository.saveAll(items)).thenReturn(items);

        mongoGroceriesApp.updateCategoryName(category);

        verify(itemRepository, times(1)).findAllByCategory(category);
        verify(itemRepository, times(1)).saveAll(items);
    }

    @Test
    void testDeleteCroceryItem() {
        String itemId = "Kodo Millet";

        doNothing().when(itemRepository).deleteById(itemId);

        mongoGroceriesApp.deleteCroceryItem(itemId);

        verify(itemRepository, times(1)).deleteById(itemId);
    }
}