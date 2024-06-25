package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService {

    private TransmissionRepository transmissionRepository;

    @Override
    public Transmission add(Transmission transmission) {
        Transmission createdTransmission = transmissionRepository.save(transmission);
        return createdTransmission;
    }

    @Override
    public List<Transmission> getAll() {
        return transmissionRepository.findAll();
    }

    @Override
    public Transmission getById(int id) {
        return transmissionRepository.findById(id).orElse(null);
    }

    @Override
    public Transmission update(int id, Transmission transmission) {
        Transmission targetTransmission = transmissionRepository.findById(id).orElse(null);
        if(targetTransmission == null){
            return null;
        }
        targetTransmission.setName(transmission.getName());
        return transmissionRepository.save(targetTransmission);
    }

    @Override
    public void delete(int id) {
        transmissionRepository.deleteById(id);
    }
}
