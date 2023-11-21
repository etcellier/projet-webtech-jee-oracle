package com.project.service.user;

import com.project.dto.UserDTO;
import com.project.entity.User;
import com.project.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    protected final UserMapper userMapper;
    protected final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public List<Optional<UserDTO>> list() {
        List<Optional<UserDTO>> userDTOList = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            userDTOList.add(Optional.ofNullable(userMapper.map(user)));
        }
        return userDTOList;
    }

    public Optional<UserDTO> get(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::map);
    }
}