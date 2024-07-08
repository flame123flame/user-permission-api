package structure.java22.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(nullable = false, length = 50)
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<MenuEntity> menus = new HashSet<>();

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users = new HashSet<>();

}
