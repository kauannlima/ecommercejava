package pojo;

import java.math.BigDecimal;

public class Product {
	
	String productId;
	String productName;
	String productDescription;
	BigDecimal productPrice;

	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	
	public Product(String productId, String productName, String productDescription, BigDecimal productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	

	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String prodDescription) {
		this.productDescription = prodDescription;
	}


	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	
	

	
}
