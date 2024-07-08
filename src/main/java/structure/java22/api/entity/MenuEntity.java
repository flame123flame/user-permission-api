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
    private Long menuId;

    @Column(nullable = false)
    private String title;

    private String icon;

    private String route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private MenuEntity parentMenu;

    @OneToMany(mappedBy = "parentMenu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MenuEntity> subMenus = new HashSet<>();

    @ManyToMany(mappedBy = "menus", fetch = FetchType.LAZY)
    private Set<RoleEntity> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "menu_buttons",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "button_id"))
    private Set<ButtonEntity> buttons = new HashSet<>();

}
