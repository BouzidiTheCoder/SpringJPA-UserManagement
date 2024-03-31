package ma.j2ee.springjpa;

import ma.j2ee.springjpa.entities.Role;
import ma.j2ee.springjpa.entities.User;
import ma.j2ee.springjpa.sevice.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {
            User u = new User();
            u.setUsername("user1");
            u.setPassword("123456");
            userService.addNewUser(u);  // Ajoute un nouvel utilisateur

            User u2 = new User();
            u2.setUsername("admin");
            u2.setPassword("000000");
            userService.addNewUser(u2); // Ajoute un autre nouvel utilisateur

            Stream.of("STUDENT", "USER", "ADMIN").forEach(r -> {
                Role role1 = new Role();
                role1.setRoleName(r);
                userService.addNewRole(role1);  // Ajoute de nouveaux rôles
            });

            userService.addRoleToUser("user1","STUDENT");   // Associe un rôle à l'utilisateur "user1"
            userService.addRoleToUser("user1","USER");
            userService.addRoleToUser("admin","USER");
            userService.addRoleToUser("admin","ADMIN");

            try{
                User user = userService.authenticate("user1","123456"); // Authentifie l'utilisateur "user1"
                System.out.println(user.getUserId());
                System.out.println(user.getUsername());
                System.out.println("Roles : ");
                user.getRoles().forEach(r ->{
                    System.out.println("Role : " +r);
                });
            }catch (Exception e){
                e.printStackTrace();    // Affiche une trace d'erreur si l'authentification échoue
            }
        };
    }

}

