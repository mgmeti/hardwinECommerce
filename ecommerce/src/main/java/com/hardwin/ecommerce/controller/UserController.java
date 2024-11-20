package com.hardwin.ecommerce.controller;

import com.hardwin.ecommerce.dto.UserDto;
import com.hardwin.ecommerce.entity.User;
import com.hardwin.ecommerce.request.CreateUserRequest;
import com.hardwin.ecommerce.request.UserUpdateRequest;
import com.hardwin.ecommerce.response.ApiResponse;
import com.hardwin.ecommerce.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}")
public class UserController {

    private final IUserService userService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long userId){
            User user = userService.getUserById(userId);
            UserDto userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new ApiResponse("Success", userDto));
    }

    @PostMapping("/users")
    public ResponseEntity<ApiResponse> createUser(@RequestBody CreateUserRequest request){
            User user = userService.createUser(request);
            UserDto userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new ApiResponse("Create User Success!", userDto));
    }
    @PutMapping("/users/{userId}")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody UserUpdateRequest request, @PathVariable Long userId) {
            User user = userService.updateUser(request, userId);
            UserDto userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new ApiResponse("Update User Success!", userDto));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId) {
            userService.deleteUser(userId);
            return ResponseEntity.ok(new ApiResponse("Delete User Success!", null));
    }
}
