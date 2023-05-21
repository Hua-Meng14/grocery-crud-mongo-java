package com.example.mongogroceriesspringboot;

import com.example.mongogroceriesspringboot.model.GroceryItem;
import com.example.mongogroceriesspringboot.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class MongoGroceriesSpringbootApplication implements CommandLineRunner {

	@Autowired
	ItemRepository groceryItemRepo;

	public static void main(String[] args) {
		SpringApplication.run(MongoGroceriesSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-------------CREATE GROCERY ITEMS-------------------------------\n");
		createGroceryItems();

		System.out.println("-------------SHOW ALL GROCERY ITEMS-------------------------------\n");
		showAllGroceryItemByName();

//		System.out.println("-------------GET ITEM BY NAME -------------------------------\n");
//		getGroceryItemByName("Whole Wheat Biscuit");
//
//		System.out.println("-------------GET ITEMS BY CATEGORY-------------------------------\n");
//		getItemByCategory("millets");
//
//		System.out.println("-------------UPDATE CATEGORY NAME OF SNACKS CATEGORY-------------------------------\n");
//		updateCategoryName("snacks");
//
//		System.out.println("-------------DELETE A GROCERY ITEMS-------------------------------\n");
//		deleteCroceryItem("Kodo Millet");
//
//		System.out.println("-------------FINAL COUNT OF GROCERY ITEMS-------------------------------\n");
//		findCountOfGroceryItems();

		System.out.println("-------------THANK YOU-------------------------------\n");
	}

	void createGroceryItems() {
		System.out.println("Data creation started.....");
		groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
		groceryItemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
		groceryItemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
		groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
		groceryItemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
		System.out.println("Data creation completed");
	}

	public void showAllGroceryItemByName() {
		groceryItemRepo.findAll().forEach(item -> System.out.println("Item: "+ item));
	}

//	public void getGroceryItemByName(String name) {
//		System.out.println("Getting item by name: "+ name);
//		GroceryItem item = groceryItemRepo.findItemByName(name);
//		System.out.println(getItemDetails(item));
//	}
//
//	public void getItemByCategory(String category) {
//		System.out.println("Getting items for the category " + category);
//		List<GroceryItem> list = groceryItemRepo.findAll(category);
//		list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: "+item.getQuantity()));
//	}
//
//	public void findCountOfGroceryItems(){
//		long count = groceryItemRepo.count();
//		System.out.println("Number of documents in the collection: "+ count);
//	}
//
//	public  String getItemDetails(GroceryItem item) {
//		System.out.println("Item Name: "+ item.getName() + ", \nQuantity: "+ item.getQuantity()+ ", \nItem Category: "+item.getCategory());
//		return "";
//	}
//
//	public  void updateCategoryName(String category) {
//		String newCategory = "munchies";
//
//		List<GroceryItem> list = groceryItemRepo.findAll(category);
//		list.forEach(item ->
//				item.setCategory(newCategory));
//
//		List<GroceryItem> itemsUpdated = groceryItemRepo.saveAll(list);
//		if(itemsUpdated != null) System.out.println("Successfully updated "+ itemsUpdated.size() + " items.");
//	}
//
//	public void deleteCroceryItem(String id) {
//		groceryItemRepo.deleteById(id);
//		System.out.println("Item with id "+ id + "deleted....");
//	}

}
