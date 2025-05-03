package devteria.identity_service.service;

import java.text.ParseException;

import com.nimbusds.jose.*;
import devteria.identity_service.dto.request.AuthenticationRequest;
import devteria.identity_service.dto.request.IntrospectRequest;
import devteria.identity_service.dto.request.LogoutRequest;
import devteria.identity_service.dto.request.RefreshRequest;
import devteria.identity_service.dto.response.AuthenticationResponse;
import devteria.identity_service.dto.response.IntrospectResponse;

public interface AuthenticationService {

    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;

    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse refreshToken(RefreshRequest request) throws ParseException, JOSEException;

    void logout(LogoutRequest request) throws ParseException, JOSEException;
}
