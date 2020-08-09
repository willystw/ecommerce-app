package com.ecommerce.auth.filter;

import com.ecommerce.auth.APISessionKey;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAuthenticatedHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            boolean filterExists = handlerMethod.getBean().getClass().isAnnotationPresent(UserAuthenticated.class);
            if (filterExists) {
                HttpSession session = request.getSession();
                return session.getAttribute(APISessionKey.USERNAME) != null &&
                        session.getAttribute(APISessionKey.USER_ID) != null;
            }
        }
        return true;
    }
}
