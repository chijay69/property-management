package com.mycompany.propertymanagement.service.Impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity propertyEntity = propertyConverter.convertDTOToEntity(propertyDTO);
        propertyEntity = propertyRepository.save(propertyEntity);

        PropertyDTO propertyDTO1 = propertyConverter.convertEntityToDTO(propertyEntity);
        return propertyDTO1;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        // The findAll() function returns an iterable that we cast to a List of type PropertyEntity
        List<PropertyEntity> propertyEntities = (List<PropertyEntity>) propertyRepository.findAll();
        // Here we created the list of PropertyDTO type
        List<PropertyDTO> propertyDTOList = new ArrayList<>();

        for (PropertyEntity pe :
                propertyEntities) {
            // propertyConverter is used to convert Entity objects to DTO
            PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
            // the converted objects are added to a list
            propertyDTOList.add(dto);
        }
        // returned DTO object list
        return propertyDTOList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long PropertyId) {
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(PropertyId);
        PropertyDTO dto = null;
        if (optionalPropertyEntity.isPresent()){
            PropertyEntity pe = optionalPropertyEntity.get();
            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
            pe.setDescription(propertyDTO.getDescription());
            pe.setPrice(propertyDTO.getPrice());

            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long PropertyId) {
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(PropertyId);
        PropertyDTO dto = null;
        if (optionalPropertyEntity.isPresent()){
            PropertyEntity pe = optionalPropertyEntity.get();
            pe.setDescription(propertyDTO.getDescription());

            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long PropertyId) {
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(PropertyId);
        PropertyDTO dto = null;
        if (optionalPropertyEntity.isPresent()){
            PropertyEntity pe = optionalPropertyEntity.get();
            pe.setPrice(propertyDTO.getPrice());

            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
