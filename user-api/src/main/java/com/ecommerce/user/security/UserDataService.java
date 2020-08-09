package com.ecommerce.user.security;

import com.ecommerce.user.entity.User;
import com.ecommerce.user.entity.UserGender;
import com.ecommerce.user.entity.UserType;

import java.time.LocalDate;

public interface UserDataService {
    User getUser(Long id);

    User getUserByUsername(String username);

    void createNewUser(String username, String password, UserType userType);

    void updateUser(Long id, String firstName, String lastName, UserGender gender, LocalDate dateOfBirth);

    boolean login(User user, String username, String password);
}
