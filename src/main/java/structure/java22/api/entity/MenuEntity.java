package structure.java22.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "menus")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuId;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(length = 50)
    private String icon;

    @Column(length = 100)
    private String route;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private MenuEntity parent;

    @OneToMany(mappedBy = "parent")
    private Set<MenuEntity> children = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "menu_buttons",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "button_id")
    )
    private Set<ButtonEntity> buttons = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "menu_roles",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles = new HashSet<>();

}
