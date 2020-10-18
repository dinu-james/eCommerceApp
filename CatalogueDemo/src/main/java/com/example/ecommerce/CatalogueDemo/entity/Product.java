package com.example.ecommerce.CatalogueDemo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    @Column(name = "version")
    private Integer version;

    @NotBlank
    @Size(min = 2)
    private String name;

    private int quantity;

    @Embedded
    private MonetaryAmount price;

    @ManyToMany
    @JoinTable(name = "products_categories", joinColumns = {
            @JoinColumn(name = "product_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "category_id", referencedColumnName = "id") })
    private List<Category> categories;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Product() {

    }

    public Product(String name, MonetaryAmount price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public MonetaryAmount getPrice() {
        return price;
    }

    public void setPrice(MonetaryAmount price) {
        this.price = price;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

	@Override
	public String toString() {
		return "Product [id=" + id + ", version=" + version + ", name=" + name + ", quantity=" + quantity + ", price="
				+ price + "]";
	}

}