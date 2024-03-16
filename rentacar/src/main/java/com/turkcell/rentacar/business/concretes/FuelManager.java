package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {

    private FuelRepository fuelRepository;


    @Override
    public Fuel add(Fuel fuel) {
        Fuel createdFuel = fuelRepository.save(fuel);
        return createdFuel;
    }

    @Override
    public List<Fuel> getAll() {
        return fuelRepository.findAll();
    }

    @Override
    public Fuel getById(int id) {
        return fuelRepository.findById(id).orElse(null);
    }

    @Override
    public Fuel update(int id, Fuel fuel) {
        Fuel targetFuel = fuelRepository.findById(id).orElse(null);
        if (targetFuel == null) {
            return null;
        }
        targetFuel.setName(fuel.getName());
        return fuelRepository.save(targetFuel);
    }

    @Override
    public void delete(int id) {
        fuelRepository.deleteById(id);
    }
}
