package com.ecommerce.user.api;

import com.ecommerce.user.model.UserLoginRequest;
import com.ecommerce.user.model.UserLoginResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public interface AuthAPI {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    UserLoginResponse login(@Valid @RequestBody UserLoginRequest request, HttpSession session);
}
