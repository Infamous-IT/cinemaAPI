package com.nhdev.cinema.service;

import com.nhdev.cinema.dto.UserDTO;
import com.nhdev.cinema.mapper.UserMapper;
import com.nhdev.cinema.model.User;
import com.nhdev.cinema.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> get() {
        return userMapper.userToUserDTOList(userRepository.findAll());
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        User updatedUser = userRepository.save(user);
        return userMapper.userToUserDTO(Optional.of(updatedUser));
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        User createdUser = userRepository.save(user);
        return userMapper.userToUserDTO(Optional.of(createdUser));
    }

    @Override
    public UserDTO getById(UUID id) {
        return userMapper.userToUserDTO(userRepository.findById(id));
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}
