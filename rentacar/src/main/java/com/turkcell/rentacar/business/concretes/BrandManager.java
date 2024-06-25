package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.GotBrandResponse;
import com.turkcell.rentacar.business.dtos.responses.UpdatedBrandResponse;
import com.turkcell.rentacar.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        brandBusinessRules.brandNameCanNotBeDuplicated(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        brand.setCreatedDate(LocalDateTime.now());
        Brand createdBrand =  brandRepository.save(brand);
        CreatedBrandResponse createdBrandResponse =
                this.modelMapperService.forResponse().map(createdBrand,CreatedBrandResponse.class);
        return createdBrandResponse;
    }

    @Override
    public List<GotBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GotBrandResponse> gotBrandResponseList = new ArrayList<>();
        for (Brand brand : brands) {
            GotBrandResponse gotBrandResponse = this.modelMapperService.forResponse().map(brand, GotBrandResponse.class);
            gotBrandResponseList.add(gotBrandResponse);
        }
        return gotBrandResponseList;
    }

    @Override
    public GotBrandResponse getById(int id) {
        brandBusinessRules.brandMustExist(id);
        Brand brand = brandRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(brand, GotBrandResponse.class);
    }

    @Override
    public UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest) {
        brandBusinessRules.brandMustExist(updateBrandRequest.getId());
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        brand.setUpdatedDate(LocalDateTime.now());
        Brand updatedBrand = brandRepository.save(brand);
        UpdatedBrandResponse updatedBrandResponse = this.modelMapperService.forResponse().map(updatedBrand, UpdatedBrandResponse.class);
        updatedBrandResponse.setUpdatedDate(updatedBrand.getUpdatedDate());
        return updatedBrandResponse;
    }

    @Override
    public void delete(int id) {
        brandBusinessRules.brandMustExist(id);
        brandRepository.deleteById(id);
    }
}
