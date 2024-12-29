package com.SplitBill.service.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {
    private String secretKey = "";
    private SecretKey secret = null;

    public JWTService() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk = keyGen.generateKey();
            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<String, Object>();
        secret = getKey();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 6000*60*100))
                .and()
                .signWith(getKey())
                .compact();
    }

    private SecretKey getKey() {
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getUsername(String token) {
        try{
            Claims claims = Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token).getPayload();
            return claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validate(String token, UserDetails userDetails) {
        try{
            Claims claims = Jwts.parser().verifyWith(getKey()).build().parseSignedClaims(token).getPayload();
            Date expiration = claims.getExpiration();
            if (expiration.before(new Date(System.currentTimeMillis()))) {
                return false;
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
