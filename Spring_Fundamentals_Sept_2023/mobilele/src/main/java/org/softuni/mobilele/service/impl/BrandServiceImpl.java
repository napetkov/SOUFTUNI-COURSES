package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.BrandDTO;
import org.softuni.mobilele.model.dto.ModelDTO;
import org.softuni.mobilele.model.entity.ModelEntity;
import org.softuni.mobilele.repository.ModelRepository;
import org.softuni.mobilele.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class BrandServiceImpl implements BrandService {

    private final ModelRepository modelRepository;

    public BrandServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<BrandDTO> getAllBrands() {
    //  TODO: Better implementation and sort by name
        Map<String, BrandDTO> brands = new TreeMap<>();

        for (ModelEntity model: modelRepository.findAll()){
            if(!brands.containsKey(model.getBrand().getBrand())){
                brands
                        .put(model.getBrand().getBrand(),
                                new BrandDTO(model.getBrand().getBrand(),
                                        new ArrayList<>()));
            }
            brands.get(model.getBrand().getBrand()).models().add(
                    new ModelDTO(model.getId(),model.getName()));
        }

        return brands.values().stream().toList();
    }
}
