package ma.j2ee.springjpa.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")  // Définit le nom de la table dans la base de données
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    private String userId;
    @Column(name = "USER_NAME",unique = true, length = 20)  // Définit le nom de la colonne dans la base de données avec des contraintes
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)  // Indique que le champ ne doit être écrit que lors de la sérialisation JSON
    private String password;
    @ManyToMany (mappedBy = "users", fetch = FetchType.EAGER)   // Relation Many-to-Many avec la classe Role, avec récupération immédiate des rôles
    private List<Role> roles = new ArrayList<>();

}
