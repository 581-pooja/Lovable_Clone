package com.poojabhagat.Lovable_clone.mapper;

import com.poojabhagat.Lovable_clone.dto.auth.SignupRequest;
import com.poojabhagat.Lovable_clone.dto.auth.UserProfileResponse;
import com.poojabhagat.Lovable_clone.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(SignupRequest signupRequest);
    UserProfileResponse toUserProfileResponse(User user);
}
