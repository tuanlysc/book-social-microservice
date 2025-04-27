package devteria.identity_service.configuration;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.SignedJWT;
import devteria.identity_service.repository.InvalidatedTokenRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class TokenValidator {
    private final InvalidatedTokenRepository repository;
    private final String signerKey;

    public TokenValidator(InvalidatedTokenRepository repository, @Value("${jwt.signerKey}") String signerKey) {
        this.repository = repository;
        this.signerKey = signerKey;
    }

    public boolean isValid(String token) throws JOSEException, ParseException {
        JWSVerifier verifier = new MACVerifier(signerKey.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(token);
        boolean verified = signedJWT.verify(verifier);
        String jit = signedJWT.getJWTClaimsSet().getJWTID();
        return verified && !repository.existsById(jit);
    }
}