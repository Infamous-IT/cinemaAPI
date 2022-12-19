package com.nhdev.cinema.service;

import com.nhdev.cinema.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserDTO> get();

    UserDTO update(UserDTO userDTO);

    UserDTO create(UserDTO userDTO);

    UserDTO getById(UUID id);

    void delete(UUID id);
}
