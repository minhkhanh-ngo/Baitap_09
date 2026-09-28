package vn.iotstar.baitap09.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import vn.iotstar.baitap09.entity.Role;
import vn.iotstar.baitap09.entity.User;
import vn.iotstar.baitap09.repository.RoleRepository;
import vn.iotstar.baitap09.repository.UserRepository;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initData(RoleRepository roles, UserRepository users, PasswordEncoder encoder) {
        return args -> {
            String adminEmail = "admin@gmail.com";
            String adminPassword = "123";

            Role userRole = roles.findByNameIgnoreCase("USER").orElseGet(() -> roles.save(new Role("USER")));
            Role adminRole = roles.findByNameIgnoreCase("ADMIN").orElseGet(() -> roles.save(new Role("ADMIN")));

            if (!users.existsByEmailIgnoreCase(adminEmail)) {
                User admin = new User();
                admin.setEmail(adminEmail);
                admin.setFullName("System Administrator");
                admin.setPassword(encoder.encode(adminPassword));
                admin.setRole(adminRole);
                admin.setEnabled(true);
                users.save(admin);
            }
        };
    }
}