package io.hunsu.hunbu.user.controller;

import io.hunsu.hunbu.user.dto.request.UserRequest;
import io.hunsu.hunbu.user.dto.response.UserResponse;
import io.hunsu.hunbu.user.service.UserService;
import io.hunsu.hunbu.util.exception.rest.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hunsu/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/{user_id}")
    public RestResponse<UserResponse> getUser(@PathVariable(name = "user_id") Integer id){
        return new RestResponse<>(userService.getUser(id), HttpStatus.OK.value());
    }

    @GetMapping
    public RestResponse<List<UserResponse>> getAllUser(){
        return new RestResponse<>(userService.getAllUser(), HttpStatus.OK.value());
    }

    @PostMapping
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public RestResponse<?> createUser(@RequestBody UserRequest request){
        userService.createUser(request.getName(), request.getEmail());
        return new RestResponse<>("유저 생성 성공", HttpStatus.OK.value());
    }

    @PutMapping("/{user_id}")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public RestResponse<?> updateUser(@RequestBody UserRequest request, @PathVariable(name = "user_id") Integer id) throws ClassNotFoundException {
        userService.updateUser(request.getName(), request.getEmail(), id);
        return new RestResponse<>("유저 업데이트 성공", HttpStatus.OK.value());
    }
}
