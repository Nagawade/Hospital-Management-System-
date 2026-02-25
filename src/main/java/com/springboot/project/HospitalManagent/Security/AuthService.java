package com.springboot.project.HospitalManagent.Security;

import com.springboot.project.HospitalManagent.dto.LoginRequestDto;
import com.springboot.project.HospitalManagent.dto.LoginResponseDto;
import com.springboot.project.HospitalManagent.dto.SignupResponseDto;
import com.springboot.project.HospitalManagent.entity.User;
import com.springboot.project.HospitalManagent.entity.type.RoleType;
import com.springboot.project.HospitalManagent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    


    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getUsername(),
                        loginRequestDto.getPassword()
                )
        );

        User user = (User) authentication.getPrincipal();

        String token = authUtil.generateToken(user); // 👈 JWT created HERE

        return new LoginResponseDto(token, user.getId());
    }


    public SignupResponseDto signup(LoginRequestDto signupRequestDto) {


        User user  = userRepository.findByUsername(signupRequestDto.getUsername()).orElse(null);

        if(user != null) throw new BadCredentialsException("User already exists");

        user = userRepository.save(User.builder()
                .username(signupRequestDto.getUsername())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))

                .build()
                );

        return new SignupResponseDto(user.getId(),user.getUsername());

    }

}
