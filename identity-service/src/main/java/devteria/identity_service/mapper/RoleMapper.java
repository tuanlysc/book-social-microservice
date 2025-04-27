package devteria.identity_service.mapper;

import devteria.identity_service.dto.request.RoleRequest;
import devteria.identity_service.dto.response.RoleResponse;
import devteria.identity_service.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
