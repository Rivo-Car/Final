package com.example.final_project.service;

import com.example.final_project.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.final_project.dto.UserDTO;
import com.example.final_project.entity.User;
import com.example.final_project.repository.UserRepository;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //public UsersDTO getAllUsers() {
        //TODO checking for an empty user list
        //return new UsersDTO(userRepository.findAll());
    //}

    public Optional<User> findByUserLogin (UserDTO userDTO){
        //TODO check for user availability. password check
        return userRepository.findByEmail(userDTO.getEmail());
    }

    public boolean saveNewUser (User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception ex) {
            log.info("{User already exists}");
            return false;
        }
    }
}

