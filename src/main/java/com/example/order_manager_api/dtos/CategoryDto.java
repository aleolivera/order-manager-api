package com.example.order_manager_api.dtos;

public class CategoryDto {
    final private Integer id;
    final private String name;
    public CategoryDto(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {return id;}
    public String getName() {return name;}
}
