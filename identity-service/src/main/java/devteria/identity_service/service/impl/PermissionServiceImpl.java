package devteria.identity_service.service.impl;

import java.util.List;

import devteria.identity_service.dto.request.PermissionRequest;
import devteria.identity_service.dto.response.PermissionResponse;
import devteria.identity_service.entity.Permission;
import devteria.identity_service.mapper.PermissionMapper;
import devteria.identity_service.repository.PermissionRepository;
import devteria.identity_service.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionServiceImpl implements PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    @Override
    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);

        return permissionMapper.toPermissionResponse(permission);
    }

    @Override
    public List<PermissionResponse> findAll() {
        var permissions = permissionRepository.findAll();

        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    @Override
    public void delete(String permissionId) {
        permissionRepository.deleteById(permissionId);
    }
}
