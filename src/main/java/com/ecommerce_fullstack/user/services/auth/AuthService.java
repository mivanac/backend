package com.ecommerce_fullstack.user.services.auth;

import com.ecommerce_fullstack.user.dto.SignupRequest;
import com.ecommerce_fullstack.user.dto.UserDto;

public interface AuthService {

    UserDto createUser(SignupRequest signupRequest);

    Boolean hasUserWithEmail(String email);
}
