package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UserConverter {
    private UserDTO userDTO;
    public UserEntity convertDTOToEntity (UserDTO userDTO){
        // Adapter design pattern
        // the object accepted is an PropertyDTO
        // the object is then converted to PropertyEntity to be sent to the PropertyRepository class

        UserEntity userEntity= new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setFullname(userDTO.getFullname());
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());

        return userEntity;
    }
    public UserDTO convertEntityToDTO(UserEntity userEntity){
        // Adapter design pattern
        // the object accepted is an PropertyDTO
        // the object is then converted to PropertyEntity to be sent to the PropertyRepository class

        UserDTO userDTO= new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setFullname(userEntity.getFullname());
        userDTO.setPhone(userEntity.getPhone());
        userDTO.setEmail(userEntity.getEmail());
        return userDTO;
    }

}
