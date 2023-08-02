package com.mycompany.propertymanagement.service.Impl;

import com.mycompany.propertymanagement.converter.UserConverter;
import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertDTOToEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntityToDTO(userEntity);

        return userDTO;
    }


    @Override
    public UserDTO login(UserDTO userDTO) {
        Optional<UserEntity> userEntity = Optional.ofNullable(userConverter.convertDTOToEntity(userDTO));
        if (userEntity.isPresent()) {
            Long id = (userEntity.get().getId());
            userEntity = userRepository.findById(id);
            //TODO
        }

        return userDTO;
    }
}
