package ma.j2ee.springjpa.repositories;

import ma.j2ee.springjpa.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}