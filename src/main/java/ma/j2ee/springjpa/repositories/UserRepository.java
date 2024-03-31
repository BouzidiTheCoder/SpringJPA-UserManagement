package ma.j2ee.springjpa.repositories;

import ma.j2ee.springjpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername (String userName);
}
