package com.e_commerce.clothes.web.controller;

import com.e_commerce.clothes.domain.entity.user.Role;
import com.e_commerce.clothes.domain.entity.user.User;
import com.e_commerce.clothes.service.UserService;
import com.e_commerce.clothes.web.dto.user.UserDTO;
import com.e_commerce.clothes.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    @GetMapping()
    public List<UserDTO> allUser() {
       List<User> users = userService.getAll();
       return userMapper.toDto(users);
    }

    @GetMapping("/{id}")
    public UserDTO getUserByID(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @GetMapping("/username/{username}")
    public UserDTO getByUsername(@PathVariable String username) {
        User user = userService.getByUsername(username);
        return userMapper.toDto(user);
    }

    // TODO : create number field
    @GetMapping("/number/{number}")
    public UserDTO getByNumber(@PathVariable String number) {
        return null;
    }

    @GetMapping("/role/{roleName}")
    public List<UserDTO> getByRole(@PathVariable String roleName) {
        Role role = Role.valueOf(roleName.toUpperCase());
        List<User> users = userService.getByRole(role);
        return userMapper.toDto(users);
    }

    @PutMapping
    public UserDTO update(@RequestBody UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User dbUser = userService.update(user);
        return userMapper.toDto(dbUser);
    }

    @PostMapping
    public UserDTO crate(@RequestBody UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User dbUser = userService.create(user);
        return userMapper.toDto(dbUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
