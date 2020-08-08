package com.ecommerce.user.api;

import com.ecommerce.user.model.UpdateUserRequest;
import com.ecommerce.user.model.UpdateUserResponse;
import com.ecommerce.user.model.ViewUserRequest;
import com.ecommerce.user.model.ViewUserResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public interface UserAPI {

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    @ResponseBody
    ViewUserResponse viewUserData(@Valid @RequestBody ViewUserRequest request, HttpSession session);

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    UpdateUserResponse updateUserData(@Valid @RequestBody UpdateUserRequest request, HttpSession session);
}
