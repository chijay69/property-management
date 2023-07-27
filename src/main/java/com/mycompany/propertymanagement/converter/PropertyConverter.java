package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    @Autowired
    private PropertyDTO propertyDTO1;

    public PropertyEntity convertDTOToEntity(PropertyDTO propertyDTO){
        // Adapter design pattern
        // the object accepted is an PropertyDTO
        // the object is then converted to PropertyEntity to be sent to the PropertyRepository class

        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setId(propertyDTO.getId());
        propertyEntity.setTitle(propertyDTO.getTitle());
        propertyEntity.setDescription(propertyDTO.getDescription());
        propertyEntity.setOwnerName(propertyDTO.getOwnerName());
        propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
        propertyEntity.setAddress(propertyDTO.getAddress());
        propertyEntity.setPrice(propertyDTO.getPrice());

        return propertyEntity;
    }

    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity){
        // Adapter design pattern
        // the object accepted is an PropertyDTO
        // the object is then converted to PropertyEntity to be sent to the PropertyRepository class

        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setOwnerName(propertyEntity.getOwnerName());
        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setPrice(propertyEntity.getPrice());

        return propertyDTO;
    }
}
