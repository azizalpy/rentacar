package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandsController {

    private BrandService brandService;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Brand add (@RequestBody Brand brand) {
        return brandService.add(brand);
    }

    @GetMapping("/getAll")
    public List<Brand> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/get")
    public Brand getById(@RequestParam int id) {
        return brandService.getById(id);
    }

    @PutMapping("/update")
    public Brand update(@RequestParam int id, @RequestBody Brand brand) {
        return brandService.update(id, brand);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) {
        brandService.delete(id);
    }
}
