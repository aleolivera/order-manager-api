package com.example.order_manager_api.dtos;

public class BrandDto {
    final private Integer id;
    final private String name;
    public BrandDto(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {return id;}
    public String getName() {return name;}
}
