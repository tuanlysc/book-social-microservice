package devteria.identity_service.service;

import java.util.List;

import devteria.identity_service.dto.request.PermissionRequest;
import devteria.identity_service.dto.response.PermissionResponse;

public interface PermissionService {

    PermissionResponse create(PermissionRequest request);

    List<PermissionResponse> findAll();

    void delete(String permissionId);
}
