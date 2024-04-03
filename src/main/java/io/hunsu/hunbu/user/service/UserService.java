package io.hunsu.hunbu.user.service;

import io.hunsu.hunbu.user.dto.response.UserResponse;
import io.hunsu.hunbu.user.repository.UserRepository;
import io.hunsu.hunbu.util.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final Integer INIT_LV = 1;

    private final UserRepository userRepository;

    public UserResponse getUser(Integer id){
        return userRepository.findOne(id).orElseThrow(() -> new ItemNotFoundException("해당 회원이 존재하지 않습니다"));
    }

    public List<UserResponse> getAllUser(){
        return userRepository.findAll().orElseThrow(() -> new ItemNotFoundException("회원이 0명 존재합니다."));
    }

    public void createUser(String title, String text){
        userRepository.save(title, text, INIT_LV);
    }

    public void updateUser(String title, String text, Integer id)  {
        userRepository.update(id, title, text);
    }

}
