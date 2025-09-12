package com.ttw.userservice.controller;

import com.ttw.userservice.payload.input.RegisterUserInput;
import com.ttw.userservice.payload.output.UserInfoOutput;
import com.ttw.userservice.payload.response.ApiResponse;
import com.ttw.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/getUserInfo")
    public ResponseEntity<ApiResponse<UserInfoOutput>> getUserInfo() {
        UUID userId = UUID.randomUUID();
        return ResponseEntity.ok(ApiResponse.success(userService.getUserInfo(userId)));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> register(@RequestBody @Valid RegisterUserInput input) {
       userService.save(input);
        return ResponseEntity.ok(ApiResponse.success(userService.save(input)));
    }

}
