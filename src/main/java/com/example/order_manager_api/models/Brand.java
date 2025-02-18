package com.example.order_manager_api.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity @Table(name="brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "brand",
            targetEntity = Product.class
    )
    private List<Product> products;

    public Brand() {}
    public Brand(Integer id, String name) {
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
        product.setBrand(this);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
        product.setBrand(null);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Brand brand = (Brand) object;
        return Objects.equals(id, brand.id) && Objects.equals(name, brand.name);
    }

    @Override
    public int hashCode() {return Objects.hash(id, name);}
}
