package devteria.apigateway.service;

import devteria.apigateway.dto.request.IntrospectRequest;
import devteria.apigateway.dto.response.ApiResponse;
import devteria.apigateway.dto.response.IntrospectResponse;
import devteria.apigateway.reposiotry.IdentityClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IdentityService {
    IdentityClient identityClient;

    public Mono<ApiResponse<IntrospectResponse>> introspect(String token) {
        return identityClient.introspect(IntrospectRequest.builder()
                        .token(token)
                .build());
    }
}
