package vn.iotstar.baitap09.service;

import vn.iotstar.baitap09.dto.UserDTO;

public interface UserService {
    UserDTO findById(Long id);
}