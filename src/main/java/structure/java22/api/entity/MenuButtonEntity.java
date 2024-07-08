package structure.java22.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "menu_buttons")
public class MenuButtonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuButtonId;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private MenuEntity menu;

    @ManyToOne
    @JoinColumn(name = "button_id")
    private ButtonEntity button;

}