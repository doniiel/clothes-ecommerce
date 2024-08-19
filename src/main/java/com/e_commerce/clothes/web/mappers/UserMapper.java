package com.e_commerce.clothes.web.mappers;

import com.e_commerce.clothes.domain.entity.user.User;
import com.e_commerce.clothes.web.dto.user.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDTO> {
}
