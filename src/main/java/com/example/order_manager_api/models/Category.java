package com.example.order_manager_api.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity @Table(name="categories")
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "category",
            targetEntity = Product.class
    )
    private List<Product> products;
    public Category() { }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public List<Product> getProducts() {return products;}
    public void setProducts(List<Product> products) {this.products = products;}

    public void addProduct(Product product){
        this.products.add(product);
        product.setCategory(this);
    }
    public void removeProduct(Product product){
        this.products.remove(product);
        product.setCategory(null);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Category category = (Category) object;
        return Objects.equals(id, category.id) && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {return Objects.hash(id, name);}
}
