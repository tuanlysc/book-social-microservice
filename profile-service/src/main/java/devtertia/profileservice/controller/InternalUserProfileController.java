package devtertia.profileservice.controller;

import org.springframework.web.bind.annotation.*;

import devtertia.profileservice.dto.request.ProfileCreationRequest;
import devtertia.profileservice.dto.response.UserProfileResponse;
import devtertia.profileservice.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InternalUserProfileController {
    UserProfileService userProfileService;

    @PostMapping("/internal/users")
    UserProfileResponse createProfile(@RequestBody ProfileCreationRequest request) {
        return userProfileService.createProfile(request);
    }
}
