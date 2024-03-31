package ma.j2ee.springjpa.sevice;

import ma.j2ee.springjpa.entities.Role;
import ma.j2ee.springjpa.entities.User;
import ma.j2ee.springjpa.repositories.UserRepository;


public interface UserService {
    User addNewUser (User user);
    Role addNewRole (Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);
    User authenticate(String userName, String password);
}
