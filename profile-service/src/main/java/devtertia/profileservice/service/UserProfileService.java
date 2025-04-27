package devtertia.profileservice.service;

import devtertia.profileservice.dto.request.ProfileCreationRequest;
import devtertia.profileservice.dto.response.UserProfileResponse;

public interface UserProfileService {
    UserProfileResponse createProfile(ProfileCreationRequest request);

    UserProfileResponse getProfile(String id);
}
