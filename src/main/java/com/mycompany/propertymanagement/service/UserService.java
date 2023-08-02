package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;

public interface UserService {
    UserDTO register(UserDTO userDTO);

    UserDTO login(UserDTO userDTO);
}
