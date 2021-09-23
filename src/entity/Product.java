package entity;

public class Product {
	
	private int productId;
	private String productName;
	private double cost;
	private String author;
	
	public Product(int id, String productName, double cost, String author) {
		setProductId(id);
		setProductName(productName);
		setCost(cost);
		setAuthor(author);
	}
	
	
	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Product() {
		setProductId(-1);
		setProductName(null);
		setCost(0);
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		
		return "{ Product name = "+getProductName()+", Product Cost = "+getCost()+", id ="+getProductId()+"}";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productId != other.productId)
			return false;
		return true;
	}

}
