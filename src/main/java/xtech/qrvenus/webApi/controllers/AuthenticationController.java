package xtech.qrvenus.webApi.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xtech.qrvenus.business.abstracts.UserService;
import xtech.qrvenus.business.requests.LoginRequest;
import xtech.qrvenus.business.requests.RegisterRequest;
import xtech.qrvenus.business.responses.LoginResponse;

@RestController
@RequestMapping("api/v1/auth")
@AllArgsConstructor
@CrossOrigin
public class AuthenticationController {
    private UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest registerRequest) {
        userService.register(registerRequest);
    }

    @PostMapping("/login")
    public LoginResponse authenticate(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }
}
