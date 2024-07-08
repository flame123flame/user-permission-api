package structure.java22.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "button_id")
    private Long buttonId;

    @Column(name = "action", nullable = false, length = 100)
    private String action;

    @Column(name = "font_color", length = 7)
    private String fontColor;

    @Column(name = "button_color", length = 7)
    private String buttonColor;

    @Column(name = "border_radius")
    private Integer borderRadius;

    @Column(name = "button_text", length = 50)
    private String buttonText;

    @Column(name = "button_details", length = 100)
    private String buttonDetails;

    @Column(length = 50)
    private String icon;

    @Column(name = "icon_color", length = 7)
    private String iconColor;

    @JsonIgnore
    @ManyToMany(mappedBy = "buttons")
    private Set<MenuEntity> menus = new HashSet<>();

}
