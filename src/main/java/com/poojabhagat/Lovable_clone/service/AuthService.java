package com.poojabhagat.Lovable_clone.service;

import com.poojabhagat.Lovable_clone.dto.auth.AuthResponse;
import com.poojabhagat.Lovable_clone.dto.auth.LoginRequest;
import com.poojabhagat.Lovable_clone.dto.auth.SignupRequest;
import org.jspecify.annotations.Nullable;

public interface AuthService {
    AuthResponse signup(SignupRequest request);
    AuthResponse login(LoginRequest request);
}
