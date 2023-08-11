package com.mycompany.propertymanagement.service.Impl;

import com.mycompany.propertymanagement.converter.UserConverter;
import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(userDTO.getEmail());
        if (optionalUserEntity.isPresent()){
            ErrorModel errorModel = new ErrorModel();
            List<ErrorModel> errorModelList = new ArrayList<>();

            errorModel.setCode("EMAIL_ALREADY_EXISTS");
            errorModel.setMessage("The email with which you are trying to register already exists.");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        UserEntity userEntity = userConverter.convertDTOToEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO = userConverter.convertEntityToDTO(userEntity);

        return userDTO;
    }


    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO;
        Optional<UserEntity> userEntity = userRepository.findByEmailAndPassword(email, password);
        if (userEntity.isPresent()) {
            userDTO = userConverter.convertEntityToDTO(userEntity.get());
        }else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID LOGIN");
            errorModel.setMessage("Incorrecct email or password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        return userDTO;
    }
}
