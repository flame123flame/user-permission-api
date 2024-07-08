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
    private Long buttonId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String action;

    @ManyToMany(mappedBy = "buttons", fetch = FetchType.LAZY)
    private Set<MenuEntity> menus = new HashSet<>();

}
