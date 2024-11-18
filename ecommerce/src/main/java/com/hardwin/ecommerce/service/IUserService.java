package com.hardwin.ecommerce.service;

import com.hardwin.ecommerce.dto.UserDto;
import com.hardwin.ecommerce.entity.User;
import com.hardwin.ecommerce.request.CreateUserRequest;
import com.hardwin.ecommerce.request.UserUpdateRequest;

public interface IUserService {

    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);

}
