package com.e_commerce.clothes.service;

import com.e_commerce.clothes.domain.entity.user.Role;
import com.e_commerce.clothes.domain.entity.user.User;

import java.util.List;

public interface UserService {
     User getById(Long id);
     List<User> getAll();
     User getByUsername(String username);
     User getByPhoneNumber(String number);
     List<User> getByRole(Role role);
     boolean existUser(String username);
     User create(User user);
     User update(User user);
     void delete(Long id);


}
