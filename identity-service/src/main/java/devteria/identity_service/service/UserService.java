package devteria.identity_service.service;

import devteria.identity_service.dto.request.UserCreationRequest;
import devteria.identity_service.dto.request.UserUpdateRequest;
import devteria.identity_service.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserCreationRequest request);

    List<UserResponse> getUsers();

    UserResponse getMyInfo();

    UserResponse getUser(String id);

    UserResponse updateUser(String userId, UserUpdateRequest request);

    void deleteUser(String userId);
}
