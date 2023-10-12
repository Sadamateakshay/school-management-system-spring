package com.akshay.services.admin;

import com.akshay.enums.UserRole;
import com.akshay.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.akshay.entities.User;

@Service
public class AdminServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void createAdminAccount(){
        User adminAccout=userRepository.findByRole(UserRole.ADMIN);
        if (adminAccout==null) {
            User admin = new User();
            admin.setEmail("admin@test.com");
            admin.setName("admin");
            admin.setRole(UserRole.ADMIN);
            admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(admin);
        }
    }
}
