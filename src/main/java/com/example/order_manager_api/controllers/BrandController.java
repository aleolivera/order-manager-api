package com.example.order_manager_api.controllers;

import com.example.order_manager_api.dto_assemblers.BrandDtoAssembler;
import com.example.order_manager_api.dto_assemblers.IDtoAssembler;
import com.example.order_manager_api.dtos.BrandDto;
import com.example.order_manager_api.models.Brand;
import com.example.order_manager_api.services.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.List;

@RestController
public class BrandController {
    @Autowired
    private IBrandService brandService;
    @Autowired
    private BrandDtoAssembler brandDtoAssembler;

    @GetMapping("/v1/brands")
    public Collection<BrandDto> findAll(){
        return brandDtoAssembler.toCollection(brandService.findAll());
    }
    @GetMapping("/v1/brands/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        Brand brand =  brandService.findById(id);

        return (brand != null)
                ? ResponseEntity
                    .ok(brandDtoAssembler.toDto(brandService.findById(id)))
                : ResponseEntity
                    .notFound()
                    .build();
    }

    @PostMapping("/v1/brands")
    public ResponseEntity<?> save(@RequestBody Brand newBrand){
        BrandDto dto = brandDtoAssembler.toDto(brandService.save(newBrand));

        if(dto == null)
            return ResponseEntity.
                    internalServerError()
                    .build();

        return ResponseEntity
                .created(URI.create("/v1/brands/"+dto.getId()))
                .body(dto);
    }

    @PutMapping("/v1/brands/{id}")
    public ResponseEntity<?> update(
            @PathVariable Integer id,
            @RequestBody Brand newBrand){

        if(!brandService.existsById(id))
            return ResponseEntity
                    .notFound()
                    .build();

        BrandDto dto = brandDtoAssembler.toDto(brandService.update(id,newBrand));

        return (dto != null)
                ? ResponseEntity
                    .created(URI.create("/v1/brands/"+id))
                    .body(dto)
                : ResponseEntity
                    .internalServerError()
                    .build();
    }

    @DeleteMapping("/v1/brands/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        if(!brandService.existsById(id)) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        brandService.delete(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
