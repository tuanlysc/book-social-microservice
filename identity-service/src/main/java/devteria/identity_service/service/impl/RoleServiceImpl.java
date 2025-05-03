package devteria.identity_service.service.impl;

import java.util.HashSet;
import java.util.List;

import devteria.identity_service.dto.request.RoleRequest;
import devteria.identity_service.dto.response.RoleResponse;
import devteria.identity_service.mapper.RoleMapper;
import devteria.identity_service.repository.PermissionRepository;
import devteria.identity_service.repository.RoleRepository;
import devteria.identity_service.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleServiceImpl implements RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

    @Override
    public RoleResponse create(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);

        return roleMapper.toRoleResponse(role);
    }

    @Override
    public List<RoleResponse> findAll() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

    @Override
    public void delete(String roleId) {
        roleRepository.deleteById(roleId);
    }
}
