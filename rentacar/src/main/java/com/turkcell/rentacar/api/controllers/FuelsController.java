package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fuels")
public class FuelsController {

    private FuelService fuelService;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Fuel add(@RequestBody Fuel fuel) {
        return fuelService.add(fuel);
    }

    @GetMapping("/getAll")
    public List<Fuel> getAll() {
        return fuelService.getAll();
    }

    @GetMapping("/get")
    public Fuel getById(@RequestParam int id) {
        return fuelService.getById(id);
    }

    @PutMapping("/update")
    public Fuel update(@RequestParam int id, @RequestBody Fuel fuel) {
        return fuelService.update(id, fuel);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) {
        fuelService.delete(id);
    }
}
