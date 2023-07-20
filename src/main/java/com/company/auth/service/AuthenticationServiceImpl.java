package com.company.auth.service;

import com.company.auth.dto.*;
import com.company.component.ResDTO;
import com.company.component.UserComponent;
import com.company.config.JwtUtil;
import com.company.exp.*;
import com.company.user.entity.UserEntity;
import com.company.user.enums.UserRole;
import com.company.user.enums.UserStatus;
import com.company.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.company.user.enums.UserStatus.ACTIVE;

@Service("authentication-service")
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public ResDTO register(RegisterRequest request) {

        UserComponent.checkPhoneNum(request.getPhone());

        Optional<UserEntity> optionalUser = repository.findByPhoneNum(request.getPhone());

        if (optionalUser.isPresent())
            throw new ItemAlreadyExistsException("User with such a phone already exists");


        UserEntity user = new UserEntity(
                request.getFullName(),
                request.getPhone(),
                passwordEncoder.encode(request.getPassword()),
                "",
                "",
                ACTIVE,
                UserRole.valueOf(request.getRole())
        );
        repository.save(user);

//        var jwtToken = JwtUtil.encode(user.getId());
        return new ResDTO();
    }


    public ResDTO authenticate(AuthenticationRequest request) {

        UserComponent.checkPhoneNum(request.getPhone());

        var user = repository.findByPhoneNum(request.getPhone())
                .orElseThrow(() -> new ItemNotFoundException("Phone is not correct"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ItemNotFoundException("Password is not correct");
        }

        if (user.getStatus().equals(UserStatus.BLOCK)
                || user.getStatus().equals(UserStatus.DELETED)) {
            throw new UserBlockException("You blocked by admin");
        }

        var jwtToken = JwtUtil.encode(user.getId());

        return new ResDTO(true, jwtToken);
    }


}
