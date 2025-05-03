package devteria.identity_service.controller;

import java.text.ParseException;

import com.nimbusds.jose.JOSEException;
import devteria.identity_service.dto.request.AuthenticationRequest;
import devteria.identity_service.dto.request.IntrospectRequest;
import devteria.identity_service.dto.request.LogoutRequest;
import devteria.identity_service.dto.request.RefreshRequest;
import devteria.identity_service.dto.response.ApiResponse;
import devteria.identity_service.dto.response.AuthenticationResponse;
import devteria.identity_service.dto.response.IntrospectResponse;
import devteria.identity_service.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    //    @PostMapping("/outbound/authentication")
    //    ApiResponse<AuthenticationResponse> outboundAuthenticate(@RequestParam("code") String code) {
    //        var result = authenticationService.outboundAuthenticate(code);
    //        return ApiResponse.<AuthenticationResponse>builder().result(result).build();
    //    }

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder().result(result).build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder().result(result).build();
    }

    @PostMapping("/refresh")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody RefreshRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.refreshToken(request);
        return ApiResponse.<AuthenticationResponse>builder().result(result).build();
    }

    @PostMapping("/logout")
    ApiResponse<Void> authenticate(@RequestBody LogoutRequest request) throws ParseException, JOSEException {
        authenticationService.logout(request);
        return ApiResponse.<Void>builder().build();
    }
}
