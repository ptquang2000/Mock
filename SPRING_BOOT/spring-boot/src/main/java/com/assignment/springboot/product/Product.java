package com.assignment.springboot.product;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.assignment.springboot.administrator.ProductForm;

@Entity
@Table(name = "product")
public class Product implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long productID;
	private String productName;
	private int unitPrice;
	private int unitInStock;
	private String productDescription;
	private int condition;
	private String imageFileName;

	@ManyToOne
	@JoinColumn(name="categoryID")
	private Category category;
	@ManyToOne
	@JoinColumn(name="manufacturerID")
	private Manufacturer manufacturer;

	public Product(){

	}

	public Product(ProductForm productForm, Category category, Manufacturer manufacturer, String imageFileName) {
		this.productName = productForm.getName();
		this.unitPrice = productForm.getPrice();
		this.unitInStock = productForm.getStock();
		this.productDescription = productForm.getDescription();
		this.condition = productForm.getCondition();
		this.imageFileName = imageFileName;
		this.setCategory(category);
		this.setManufacturer(manufacturer);
  }

  public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Manufacturer getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Long getProductID() {
		return this.productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitInStock() {
		return this.unitInStock;
	}

	public void setUnitInstock(int unitInStock) {
		this.unitInStock = unitInStock;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getCondition() {
		return this.condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	public String getImageFileName() {
		return this.imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	@Override
	public String toString() {
		return "\nProduct{" +
			"\n\tproductID='" + getProductID() + "'" +
			",\n\tproductName='" + getProductName() + "'" +
			",\n\tunitPrice='" + getUnitPrice() + "'" +
			",\n\tunitInStock='" + getUnitInStock() + "'" +
			",\n\tproductDescription='" + getProductDescription() + "'" +
			",\n\tmanufacturer='" + getManufacturer() + "'" +
			",\n\tcategory='" + getCategory() + "'" +
			",\n\tcondition='" + getCondition() + "'" +
			",\n\timageFileName='" + getImageFileName() + "'" +
			"\n}";
	}

}