package vn.iotstar.baitap09.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import vn.iotstar.baitap09.entity.Role;
import vn.iotstar.baitap09.entity.User;
import vn.iotstar.baitap09.repository.RoleRepository;
import vn.iotstar.baitap09.repository.UserRepository;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    @Bean
    CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Role userRole = roleRepository.findByName("ROLE_USER")
                    .orElseGet(() -> roleRepository.save(Role.builder().name("ROLE_USER").build()));

            if (userRepository.findByUsername("user01").isEmpty()) {
                User user = User.builder()
                        .username("user01")
                        .email("user01@gmail.com")
                        .password(passwordEncoder.encode("123456"))
                        .fullName("Ngô Minh Khánh")
                        .images("/images/user.png")
                        .role(userRole)
                        .enabled(true)
                        .build();
                userRepository.save(user);
            }
        };
    }
}