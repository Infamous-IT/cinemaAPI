package com.nhdev.cinema.controller;

import com.nhdev.cinema.dto.UserDTO;
import com.nhdev.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = ServiceAPIUrl.VERSION_PATH + "/user";

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> get() {
        return userService.get();
    }

    @GetMapping(value = "/{id}")
    public UserDTO getById(@PathVariable UUID id) {
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @PatchMapping(value = "/{id}")
    public UserDTO update(@RequestBody UserDTO userDTO) {
        return userService.update(userDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }
}
