package vn.iotstar.baitap09.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.iotstar.baitap09.dto.UserDTO;
import vn.iotstar.baitap09.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "roleName", source = "role.name")
    UserDTO toDTO(User user);
}