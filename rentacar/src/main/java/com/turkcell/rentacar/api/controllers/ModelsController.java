package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/models")
public class ModelsController {

    private ModelService modelService;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Model add(@RequestBody Model model) {
        return modelService.add(model);
    }

    @GetMapping("/getAll")
    public List<Model> getAll() {
        return modelService.getAll();
    }

    @GetMapping("/get")
    public Model getById(@RequestParam int id) {
        return modelService.getById(id);
    }

    @PutMapping("/update")
    public Model update(@RequestParam int id, @RequestBody Model model) {
        return modelService.update(id, model);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) {
        modelService.delete(id);
    }
}
