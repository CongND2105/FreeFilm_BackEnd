package com.example.demo.Controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/test")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if(userEntity == null){
            return ResponseEntity.notFound().build();
        }
        UserDTO userDTO = userMapper.toDTO(userEntity);
        return ResponseEntity.ok(userDTO);
    }

}
