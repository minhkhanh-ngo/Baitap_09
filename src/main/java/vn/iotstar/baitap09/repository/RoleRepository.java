package vn.iotstar.baitap09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.iotstar.baitap09.entity.Role;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNameIgnoreCase(String name);
}