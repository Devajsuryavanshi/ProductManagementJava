package client;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entity.Product;
import exception.ProductException;
import service.ShoppingServices;

public class ShoppingManagement {
	
	private static Set<Product> products = new HashSet<>();
	private static ShoppingServices service = new ShoppingServices();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ProductException {
		
		System.out.println("Enter the number of products you want to enter");
		int size = sc.nextInt();
		sc.nextLine();
		
		addProducts(size);
		
		System.out.println("****Welcome To Shopping Management System****");
		
		System.out.println("1) Add a new Product, id, author\r\n"
				+ "\r\n"
				+ "2) List all Product with name, Id\r\n"
				+ "\r\n"
				+ "3) Search Product with ID\r\n"
				+ "\r\n"
				+ "4) Edit Product by name\r\n"
				+ "\r\n"
				+ "5) Delete Product by ID\r\n"
				+ "\r\n"
				+ "6) Exit");
		
		boolean running = true;
		
		while(running) {
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice){
			
			case 1:{
				addProducts(1);
			}
			break;
			
			case 2:{
				for(Product p: products) {
					System.out.println(p);
				}
			}
			
			break;
			
			case 3:{
				System.out.println("Enter the id you want to search");
				int id = sc.nextInt();
				sc.nextLine();
				
				Product searched = service.searchByID(products, id);
				if(searched == null) {
					throw new ProductException("No Product Found");
				}
				else {
					System.out.println(searched);
				}
			}
			break;
			
			case 4:{
				
				System.out.println("Enter the product name you want to replace");
				String name = sc.nextLine();
				
				System.out.println("Enter the id of the new product ");
				int id = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter the new Name");
				String newName = sc.nextLine();
				
				System.out.println("Enter the new price");
				double cost = sc.nextDouble();
				sc.nextLine();
				
				System.out.println("Enter the new author");
				String author = sc.nextLine();
				
				boolean result = service.editByName(products, name, newName, id, cost, author);
				if(result)
					System.out.println("Success!");
				else throw new ProductException("No product found by that name");
			}
			break;
			
			case 5:{
				System.out.println("Enter the product id you want to delete");
				int id = sc.nextInt();
				sc.nextLine();
				
				boolean result = service.deletebyId(products, id);
				if(result)
					System.out.println("Success!");
				else
					throw new ProductException("No product found by that id");		
				
			}
			break;
			
			case 6:{
				running = false;
				System.out.println("_______EXIT_______");
			break;
			}
			
			default: {
				System.out.println("Incorrect choice, if you want to"
						+ " exit then press 6");
			}
			}
			if(running)
				System.out.println("Enter the choice again: ");
			}
	}
	
	private static void addProducts(int size) {
		
		for(int i =0; i < size; i++) {
			
			System.out.println("Enter the id of the product ");
			int id = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter the Name");
			String name = sc.nextLine();
			
			System.out.println("Enter the price");
			double cost = sc.nextDouble();
			sc.nextLine();
			
			System.out.println("Enter the author");
			String author = sc.nextLine();
			
			products.add(new Product(id, name, cost, author));
		}
	}

}
