package pl.coderslab.dragondice.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;;
import lombok.*;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "playable_characters")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int charLevel;
    @NotBlank
    private String charName;
    @NotNull
    private int charAge;
    private String charAlignment;
    @Size(max = 2000)
    private String backstory;

    private int proficiency;
    private int expertise;

    private int strAbility;
    private int dexAbility;
    private int conAbility;
    private int intAbility;
    private int wisAbility;
    private int chaAbility;

    @ManyToOne
    private Race race;
    @ManyToOne
    private Background background;
    @ManyToMany
    private List<Feats> feats;

    @ManyToOne
    private User user;
}
