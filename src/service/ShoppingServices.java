package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import entity.Product;

public class ShoppingServices implements ShoppingInterface {

	@Override
	public Product searchByID(Set<Product> products, int id) {
		
		return getIndexedProduct(products,id);
	}

	@Override
	public boolean editByName(Set<Product> products, String name, String updatedName, int id, double cost, String author) {
		//Returns object by name to be edited.
		
		List<Product> arr = new ArrayList<>(products);
		Product tobeUpdated = null;
		boolean found = true;
		for(int i = 0; i< arr.size(); i++) {
			if(arr.get(i).getProductName().equals(name)) {
				tobeUpdated = arr.get(i);
				found = true;
				break;
			}
		}
		if(found == true) {
		 products.remove(tobeUpdated);
		 products.add(new Product(id, updatedName, cost, author));
		 return true;
	   }
		else return false;
		
	}

	@Override
	public boolean deletebyId(Set<Product> products, int id) {
		
		List<Product> filteredproduct = products
				  .stream()
				  .filter(c -> c.getProductId() == (id))
				  .collect(Collectors.toList());
		if(filteredproduct.isEmpty()){
		return false;
		}
		else {
			products.remove(filteredproduct.get(0));
			return true;
		}
	}

	@Override
	public List<Product> sortById(Set<Product> products) {
		
		List<Product> sortedbyId = new ArrayList<>(products);
		Comparator<Product> byid = (e1,e2) ->{return (e1.getProductId() - e2.getProductId());};
		sortedbyId.sort(byid);
		
		return sortedbyId;
	}
	
	private Product getIndexedProduct(Set<Product> products, int id) {
		
	    List<Product> arr = new ArrayList<>(products);
		
		for(int i = 0; i< products.size(); i++) {
			
			if(id == arr.get(i).getProductId()) {
				return arr.get(i);
			}
		}
		return null;
	}

	
	
}
