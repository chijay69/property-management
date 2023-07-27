package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {
    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();

    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long PropertyId);

    PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long PropertyId);

    PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long PropertyId);
    void deleteProperty(Long PropertyId);
}
