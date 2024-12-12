package com.udemy.demo.controller;

import com.udemy.demo.dto.request.ApiResponse;
import com.udemy.demo.dto.request.UserCreationRequest;
import com.udemy.demo.dto.request.UserUpdateRequest;
import com.udemy.demo.dto.response.UserResponse;
import com.udemy.demo.entity.User;
import com.udemy.demo.service.UserService;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }

    @GetMapping
    ApiResponse<List<UserResponse>> getUsers() {
        return ApiResponse.<List<UserResponse>>builder()
        .result(userService.getUsers())
        .build();
    }

    @GetMapping("{userId}")
    ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.getUser(userId));

        return apiResponse;
    }

    @PutMapping("{userId}")
    UserResponse updateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("{userId}")
    String deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);

        return "delete complete";
    }
}
