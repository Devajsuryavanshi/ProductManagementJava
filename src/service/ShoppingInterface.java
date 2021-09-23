package service;

import java.util.List;
import java.util.Set;

import entity.Product;

public interface ShoppingInterface {
	
	public Product searchByID(Set<Product> products, int id);
	
	public boolean editByName(Set<Product> products, String name, String updatedName, int id, double cost, String author);
	
	public boolean deletebyId(Set<Product> products,int id);
	
	public List<Product> sortById(Set<Product> products);

}
