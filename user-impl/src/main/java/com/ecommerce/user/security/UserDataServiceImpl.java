package com.ecommerce.user.security;

import com.ecommerce.user.entity.User;
import com.ecommerce.user.entity.UserGender;
import com.ecommerce.user.entity.UserRole;
import com.ecommerce.user.entity.UserType;
import com.ecommerce.user.repository.UserDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserDataServiceImpl implements UserDataService {

    private static final Logger log = LoggerFactory.getLogger(UserDataServiceImpl.class);

    @Autowired
    private UserDataRepository userDataRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User getUser(Long id) {
        return userDataRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userDataRepository.getByUsername(username);
        return user;
    }

    @Override
    public void createNewUser(String username, String password, UserType userType) {
        User user = new User();
        user.setRole(UserRole.USER);
        user.setType(userType);
        user.setUsername(username);
        user.setPasswordHash(passwordEncoder.encode(password));

        userDataRepository.save(user);
    }


    @Override
    public void updateUser(Long id,
                           String firstName, String lastName,
                           UserGender gender,
                           LocalDate dateOfBirth) {
        User user = userDataRepository.findById(id).orElse(null);
        if (user != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setGender(gender);
            user.setDateOfBirth(dateOfBirth);

            userDataRepository.save(user);
        }

    }

    @Override
    public boolean login(String username, String password) {
        User user = userDataRepository.getByUsername(username);
        if (user != null) {
            String passHash = user.getPasswordHash();
            return passwordEncoder.matches(password, passHash);
        }
        return false;
    }
}
