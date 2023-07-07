package com.example.klymovych.contactsBook.service.Impl;

import com.example.klymovych.contactsBook.dto.JwtRequest;
import com.example.klymovych.contactsBook.dto.JwtResponse;
import com.example.klymovych.contactsBook.dto.RegistrationUserDto;
import com.example.klymovych.contactsBook.dto.UserDto;
import com.example.klymovych.contactsBook.exception.AppError;
import com.example.klymovych.contactsBook.security.jwt.JwtTokenUtils;
import com.example.klymovych.contactsBook.model.User;
import com.example.klymovych.contactsBook.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;

    private final JwtTokenUtils jwtTokenUtils;

    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        log.info("Creating authentication token for user: {}", authRequest.getUsername());

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                    authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            log.error("Authentication failed for user: {}", authRequest.getUsername());
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(),
                    "Incorrect login or password"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        log.info("Authentication successful for user: {}", authRequest.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto registrationUserDto) {
        log.info("Creating new user: {}", registrationUserDto.getEmail());
        if (!registrationUserDto.getPassword().equals(registrationUserDto.getConfirmPassword())) {
            log.error("Password mismatch for user: {}", registrationUserDto.getEmail());
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
                    "Password mismatch"), HttpStatus.BAD_REQUEST);
        }
        if (userService.findByEmail(registrationUserDto.getEmail()).isPresent()) {
            log.error("User with the given name or login already exists: {}", registrationUserDto.getEmail());
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
                    "User with the given email already exists"), HttpStatus.BAD_REQUEST);
        }
        User user = userService.create(registrationUserDto);
        log.info("User created: {}", user.getEmail());
        return ResponseEntity.ok(new UserDto(user.getId(), user.getUsername(), user.getEmail()));
    }
}
