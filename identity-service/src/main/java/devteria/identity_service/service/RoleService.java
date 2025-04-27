package devteria.identity_service.service;

import java.util.List;

import devteria.identity_service.dto.request.RoleRequest;
import devteria.identity_service.dto.response.RoleResponse;

public interface RoleService {
    RoleResponse create(RoleRequest request);

    List<RoleResponse> findAll();

    void delete(String roleId);
}
