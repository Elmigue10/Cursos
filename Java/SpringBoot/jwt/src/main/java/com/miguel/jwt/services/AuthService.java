package com.miguel.jwt.services;

import com.miguel.jwt.dto.JwtResponse;
import com.miguel.jwt.dto.UserDto;
import com.miguel.jwt.security.JwtIO;
import com.miguel.jwt.util.DateUtils;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
    @Autowired
    private JwtIO jwtIO;
    @Autowired
    private DateUtils dateUtils;
    
    @Value("${jms.jwt.token.expires-in}")
    private int EXPIRES_IN;
    
    public JwtResponse login(String clientId, String clientSecret){
        
        UUID uid = UUID.randomUUID();
        
        UserDto userDto = UserDto.builder()
                .firstName("Miguel")
                .lastName("Valbuena")
                .role("Admin")
                .country("Colombia")
                .uid(uid.toString())
                .build();
        
        JwtResponse jwt = JwtResponse.builder()
                .tokenType("bearer")
                .accessToken(jwtIO.generateToken(userDto))
                .issuedAt(dateUtils.getDateMilis()+"")
                .clientId(clientId)
                .expiresIn(EXPIRES_IN)
                .build();
        
        return jwt;
    }
    
}
