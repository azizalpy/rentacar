package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;


    @Override
    public Model add(Model model) {
        Model createdModel = modelRepository.save(model);
        return createdModel;
    }

    @Override
    public List<Model> getAll() {
        return modelRepository.findAll();
    }

    @Override
    public Model getById(int id) {
        return modelRepository.findById(id).orElse(null);
    }

    @Override
    public Model update(int id, Model model) {
        Model targetModel = modelRepository.findById(id).orElse(null);
        if(targetModel == null){
            return null;
        }
        targetModel.setName(model.getName());
        return modelRepository.save(targetModel);
    }

    @Override
    public void delete(int id) {
        modelRepository.deleteById(id);
    }
}
