package devteria.identity_service.mapper;

import devteria.identity_service.dto.request.ProfileCreationRequest;
import devteria.identity_service.dto.request.UserCreationRequest;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Profile;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
     ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);
}
