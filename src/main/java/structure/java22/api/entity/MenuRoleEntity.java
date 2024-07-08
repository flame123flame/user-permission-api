package structure.java22.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@jakarta.persistence.Entity
@Getter
@Setter
@Table(name = "menu_roles")
public class MenuRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuRoleId;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private MenuEntity menu;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

}