package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/transmissions")
public class TransmissionsController {

    private TransmissionService transmissionService;

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Transmission add(@RequestBody Transmission transmission) {
        return transmissionService.add(transmission);
    }

    @GetMapping("/getAll")
    public List<Transmission> getAll() {
        return transmissionService.getAll();
    }

    @GetMapping("/get")
    public Transmission getById(@RequestParam int id) {
        return transmissionService.getById(id);
    }

    @PutMapping("/update")
    public Transmission update(@RequestParam int id, @RequestBody Transmission transmission) {
        return transmissionService.update(id, transmission);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) {
        transmissionService.delete(id);
    }
}
