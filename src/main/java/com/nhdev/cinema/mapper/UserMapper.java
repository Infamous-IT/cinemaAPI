package com.nhdev.cinema.mapper;

import com.nhdev.cinema.dto.UserDTO;
import com.nhdev.cinema.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.Optional;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserDTO userToUserDTO(Optional<User> user);

    List<UserDTO> userToUserDTOList(List<User> userList);

    User userDTOToUser(UserDTO userDTO);
}
