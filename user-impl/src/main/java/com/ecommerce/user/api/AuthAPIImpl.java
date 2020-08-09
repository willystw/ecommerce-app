package com.ecommerce.user.api;

import com.ecommerce.auth.APISessionKey;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.model.UserLoginFailedReason;
import com.ecommerce.user.model.UserLoginRequest;
import com.ecommerce.user.model.UserLoginResponse;
import com.ecommerce.user.security.UserDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

public class AuthAPIImpl implements AuthAPI {

    private static final Logger logger = LoggerFactory.getLogger(AuthAPIImpl.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDataService userDataService;

    @Override
    public UserLoginResponse login(@Valid UserLoginRequest request, HttpSession session) {
        String username = request.getUsername();
        User existingUser = userDataService.getUserByUsername(username);

        boolean successLogin;
        if (existingUser == null) {
            //create new user
            userDataService.createNewUser(username, request.getPassword(), request.getDeviceInterface());
            existingUser = userDataService.getUserByUsername(username);

            successLogin = true;
        } else {
            //login for existing user
            successLogin = userDataService.login(existingUser, username, request.getPassword());
        }

        UserLoginResponse response = new UserLoginResponse();
        if (successLogin) {
            session.setAttribute(APISessionKey.USERNAME, username);
            session.setAttribute(APISessionKey.USER_ID, existingUser.getId());

            response.setSuccess(true);
        } else {
            response.setReason(UserLoginFailedReason.AUTH_FAILED);
        }

        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
