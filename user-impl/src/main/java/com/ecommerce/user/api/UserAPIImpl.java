package com.ecommerce.user.api;

import com.ecommerce.auth.APISessionKey;
import com.ecommerce.auth.filter.UserAuthenticated;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.model.UpdateUserRequest;
import com.ecommerce.user.model.UpdateUserResponse;
import com.ecommerce.user.model.ViewUserRequest;
import com.ecommerce.user.model.ViewUserResponse;
import com.ecommerce.user.security.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@UserAuthenticated
public class UserAPIImpl implements UserAPI {
    @Autowired
    private UserDataService userDataService;

    @Override
    public ViewUserResponse viewUserData(@Valid ViewUserRequest request, HttpSession session) {
        long id = Long.parseLong(session.getAttribute(APISessionKey.USER_ID).toString());

        User user = userDataService.getUser(id);
        ViewUserResponse response = new ViewUserResponse();
        if (user != null) {
            response.setFirstName(user.getFirstName());
            response.setLastName(user.getLastName());
            response.setGender(user.getGender());
            response.setDateOfBirth(user.getDateOfBirth());
        }
        return response;
    }

    @Override
    public UpdateUserResponse updateUserData(@Valid UpdateUserRequest request, HttpSession session) {
        long id = Long.parseLong(session.getAttribute(APISessionKey.USER_ID).toString());
        userDataService.updateUser(
                id,
                request.getFirstName(),
                request.getLastName(),
                request.getGender(),
                request.getDateOfBirth()
        );
        UpdateUserResponse response = new UpdateUserResponse();
        response.setSuccess(true);

        return response;
    }
}
