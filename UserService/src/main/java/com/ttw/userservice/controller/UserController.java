package com.ttw.userservice.controller;

import com.ttw.userservice.model.User;
import com.ttw.userservice.payload.input.RegisterUserInput;
import com.ttw.userservice.payload.input.UpdateProfileInput;
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
    public ResponseEntity<ApiResponse<UserInfoOutput>> getUserInfo(@Valid @RequestParam("userId") Long userId) {
        return ResponseEntity.ok(ApiResponse.success(userService.getUserInfo(userId)));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> register(@Valid @RequestBody  RegisterUserInput input) {
        System.out.println("printing in controller");
        System.out.println(input.username() + input.age() + input.email());
        try {
            User res = userService.save(input);
            System.out.println(res + " printing after saving the user.. ");
            return ResponseEntity.ok(ApiResponse.success(res.toString()));
        } catch (Exception e) {
            e.printStackTrace(); // print the real error
            return ResponseEntity.badRequest().body(ApiResponse.failure(e.getMessage(), e.getMessage()));
        }
    }
    @PutMapping("/updateProfile")
    public ResponseEntity<ApiResponse<UserInfoOutput>> upddateProfile(@RequestParam("userId") Long userId,@RequestBody UpdateProfileInput input) {
      return ResponseEntity.ok(ApiResponse.success(userService.updateProfile(userId,input)));
    }

}
