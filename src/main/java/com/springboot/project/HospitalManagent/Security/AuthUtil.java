package com.springboot.project.HospitalManagent.Security;

import com.springboot.project.HospitalManagent.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
@RequiredArgsConstructor
@AllArgsConstructor
public class AuthUtil {

    @Value("${jwt.secretKey}")
    private String jwtSecretKey ;

    private SecretKey getsecretKey(){
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(User user){

        return Jwts.builder()
                .subject(user.getUsername())
                .claim("userid",user.getId().toString())
                .issuedAt(new Date())

                .expiration(new java.sql.Date(System.currentTimeMillis()+1000*60*10))
                .signWith(getsecretKey())
                .compact();

    }


    public String getUsernamefromTocken(String tocken) {
        Claims claims = Jwts.parser()
                .verifyWith(getsecretKey())
                .build()
                .parseSignedClaims(tocken)
                .getPayload();
        return claims.getSubject();
    }
}
