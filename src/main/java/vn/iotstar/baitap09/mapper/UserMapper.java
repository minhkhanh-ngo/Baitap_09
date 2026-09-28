package vn.iotstar.baitap09.mapper;

import org.mapstruct.*;
import vn.iotstar.baitap09.dto.UserDTO;
import vn.iotstar.baitap09.entity.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    @Mapping(target="roleId", source="role.id")
    @Mapping(target="roleName", source="role.name")
    UserDTO toDto(User entity);

    @Mapping(target="role", ignore=true)
    @Mapping(target="products", ignore=true)
    User toEntity(UserDTO dto);
}