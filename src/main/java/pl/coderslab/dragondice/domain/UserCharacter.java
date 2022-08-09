package pl.coderslab.dragondice.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;;
import lombok.*;
import org.springframework.lang.Nullable;

import java.util.List;

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
    private long id;                    //automatic
    private int charLevel;              //done
    private String charName;            //done
    private int charAge;                //done
    private String charAlignment;       //done
    @Size(max = 2000)
    private String backstory;           //done

    private int proficiency;            //done
    private int expertise;              //done

    private int strAbility;             //done
    private int dexAbility;             //done
    private int conAbility;             //done
    private int intAbility;             //done
    private int wisAbility;             //done
    private int chaAbility;             //done

    @ManyToOne
    private Race race;                  //done
    @ManyToOne
    private Background background;      //done
    @ManyToMany
    private List<Feats> feats;          //done
}
