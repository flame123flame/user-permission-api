package structure.java22.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "buttons")
public class ButtonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buttonId;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(name = "action", nullable = false, length = 100)
    private String action;

    @ManyToMany(mappedBy = "buttons")
    private Set<MenuEntity> menus = new HashSet<>();

}
