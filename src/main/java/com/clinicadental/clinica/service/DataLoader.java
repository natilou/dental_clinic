package com.clinicadental.clinica.service;

import com.clinicadental.clinica.model.User;
import com.clinicadental.clinica.model.UserRoles;
import com.clinicadental.clinica.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //Encrypt passwords
        BCryptPasswordEncoder passwordEncoder1 = new BCryptPasswordEncoder();
        String password = passwordEncoder1.encode("password");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String password2 = passwordEncoder2.encode("password2");

        //Create two user instances
        User user1 = new User("admin", "admin2@dentalclinc.com", password, UserRoles.ADMIN);
        User user2 = new User("user", "user2@dentalclinic.com", password2, UserRoles.USER);

        this.iUserRepository.save(user1);
        this.iUserRepository.save(user2);

    }
}
