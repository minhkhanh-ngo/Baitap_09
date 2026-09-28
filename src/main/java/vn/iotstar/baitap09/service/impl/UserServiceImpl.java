package vn.iotstar.baitap09.service.impl;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import vn.iotstar.baitap09.dto.UserDTO;
import vn.iotstar.baitap09.entity.User;
import vn.iotstar.baitap09.mapper.UserMapper;
import vn.iotstar.baitap09.repository.UserRepository;
import vn.iotstar.baitap09.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.toDTO(user);
    }
}