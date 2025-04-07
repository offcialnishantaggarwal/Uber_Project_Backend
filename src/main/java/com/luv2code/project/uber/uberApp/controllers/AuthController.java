package com.luv2code.project.uber.uberApp.controllers;

import com.luv2code.project.uber.uberApp.dto.*;
import com.luv2code.project.uber.uberApp.services.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody SignupDto signupDto) {
        return new ResponseEntity<>(authService.signup(signupDto), HttpStatus.CREATED);
    }

    @PostMapping("/onboardNewDriver/{userId}")
    public ResponseEntity<DriverDto> onboardNewDriver(@PathVariable Long userId, @RequestBody OnboardDriverDto onboardDriverDto){
        return new ResponseEntity<>(authService.onboardNewDriver(userId,onboardDriverDto.getVehicleId()),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto,
                                                  HttpServletRequest request,
                                                  HttpServletResponse response){
        String tokens[] = authService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
        Cookie cookie = new Cookie("token",tokens[1]);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseEntity.ok(new LoginResponseDto(tokens[0]));
    }

}
