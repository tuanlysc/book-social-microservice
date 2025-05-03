package devtertia.profileservice.mapper;

import org.mapstruct.Mapper;

import devtertia.profileservice.dto.request.ProfileCreationRequest;
import devtertia.profileservice.dto.response.UserProfileResponse;
import devtertia.profileservice.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileResponse(UserProfile userProfile);
}
