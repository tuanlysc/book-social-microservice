package devteria.identity_service.mapper;

import devteria.identity_service.dto.request.PermissionRequest;
import devteria.identity_service.dto.response.PermissionResponse;
import devteria.identity_service.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
