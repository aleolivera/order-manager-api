package com.example.order_manager_api.models;

import jakarta.persistence.*;
import org.hibernate.annotations.SoftDelete;
import java.time.LocalDate;
import java.util.Objects;

@Entity @Table(name="products") @SoftDelete
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private Integer stock = 0;
    @Column(nullable = false)
    private Integer maxStock = 0;
    @Column(nullable = false)
    private Integer minStock = 0;
    @Column(nullable = false)
    private Double price = 0.00D;
    @Column(nullable = false)
    private LocalDate created = LocalDate.now();

    @ManyToOne(
            targetEntity = Brand.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "brand_id",
            referencedColumnName = "id"
    )
    private Brand brand;

    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = Category.class
    )
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "id"
    )
    private Category category;

    public Product() {}

    public Product(
            Long id, String name, String description, Double price,
            Integer stock, Integer maxStock, Integer minStock,
            LocalDate created, Brand brand, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.maxStock = maxStock;
        this.minStock = minStock;
        this.created = created;
        this.brand = brand;
        this.category = category;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public Integer getStock() {return stock;}
    public void setStock(Integer stock) {
        this.stock = (stock > 0) ? stock : 0 ;
    }
    public Integer getMaxStock() {return maxStock;}
    public void setMaxStock(Integer maxStock) {
        this.maxStock = (maxStock > 0) ? maxStock : 0 ;
    }
    public Integer getMinStock() {return minStock;}
    public void setMinStock(Integer minStock) {
        this.minStock = (minStock > 0 ) ? minStock : 0;
    }
    public Double getPrice() {return price;}
    public void setPrice(Double price) {
        this.price = (price > 0) ? price : 0;
    }
    public LocalDate getCreated() {return created;}
    public void setCreated(LocalDate created) {this.created = created;}
    public Brand getBrand() {return brand;}
    public void setBrand(Brand brand) {this.brand = brand;}
    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(stock, product.stock) &&
                Objects.equals(maxStock, product.maxStock) &&
                Objects.equals(minStock, product.minStock) &&
                Objects.equals(price, product.price) &&
                Objects.equals(brand, product.brand) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, stock, maxStock, minStock, price, brand, category);
    }
}
