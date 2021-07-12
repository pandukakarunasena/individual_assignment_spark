package com.panduka.ncms.auth;

import com.panduka.ncms.exception.InvalidJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Instant;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import java.time.temporal.ChronoUnit;

public class TokenGenerator {

    // Key is hardcoded here for simplicity.
    // Ideally this will get loaded from env configuration/secret vault
    String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
    Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS256.getJcaName());

    public String generateToken(String username, String password) {
        Instant now = Instant.now();

        String jwtToken = Jwts.builder().claim("name", username).claim("password", password).setSubject("jane")
                .setId(UUID.randomUUID().toString()).setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(50l, ChronoUnit.MINUTES))).signWith(hmacKey).compact();

        return jwtToken;
    }

    public Jws<Claims> parseJwt(String jwtString) throws InvalidJwtException {

        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS256.getJcaName());
        Jws<Claims> jwt = Jwts.parserBuilder().setSigningKey(hmacKey).build().parseClaimsJws(jwtString);
        if (jwt == null) {
            throw new InvalidJwtException();
        }

        return jwt;
    }

}
