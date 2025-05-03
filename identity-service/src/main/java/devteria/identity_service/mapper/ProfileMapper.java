package devteria.identity_service.mapper;

import devteria.identity_service.dto.request.ProfileCreationRequest;
import devteria.identity_service.dto.request.UserCreationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);
}
