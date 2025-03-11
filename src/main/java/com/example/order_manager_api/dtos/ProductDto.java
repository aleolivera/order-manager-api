package com.example.order_manager_api.dtos;
import java.time.LocalDate;

public class ProductDto {
    final private Long id;
    final private String name;
    final private String description;
    final private Integer stock;
    final private Integer maxStock;
    final private Integer minStock;
    final private Double price;
    final private LocalDate created;
    final private BrandDto brand;
    final private CategoryDto category;

    public ProductDto(
            Long id,
            String name,
            String description,
            Integer stock,
            Integer maxStock,
            Integer minStock,
            Double price,
            LocalDate created,
            BrandDto brandDto,
            CategoryDto categoryDto) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.maxStock = maxStock;
        this.minStock = minStock;
        this.price = price;
        this.created = created;
        this.brand = brandDto;
        this.category = categoryDto;
    }

    public Long getId() {return id;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public Integer getStock() {return stock;}
    public Integer getMaxStock() {return maxStock;}
    public Integer getMinStock() {return minStock;}
    public Double getPrice() {return price;}
    public LocalDate getCreated() {return created;}
    public BrandDto getBrand() {return brand;}
    public CategoryDto getCategory() {return category;}
}
