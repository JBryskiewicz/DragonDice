package pl.coderslab.dragondice.domain;

import javax.persistence.*;;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "user_characters")
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
    private String charName;
    private int charAge;
    private String charAlignment;
    private String backstory;
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

}
