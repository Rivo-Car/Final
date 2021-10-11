package com.example.final_project.service;

import com.example.final_project.repository.UserRepository;
import com.example.final_project.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class OurUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username).get();
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new OurUserDetails(user);
    }
}