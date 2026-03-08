package com.poojabhagat.Lovable_clone.dto.auth;

public record AuthResponse(
        String token,
        UserProfileResponse user
) {
}

// dummy: new AuthResponse("", new UserProfile)
// class only but with some extra functionality