package pl.coderslab.dragondice.domain;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScoreIncrease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int strIncreaseFour;
    private int dexIncreaseFour;
    private int conIncreaseFour;
    private int intIncreaseFour;
    private int wisIncreaseFour;
    private int chaIncreaseFour;
    @OneToOne(cascade = CascadeType.ALL)
    private UserCharacter userCharacter;

    public ScoreIncrease(int strIncreaseFour, int dexIncreaseFour, int conIncreaseFour, int intIncreaseFour, int wisIncreaseFour, int chaIncreaseFour) {
        this.strIncreaseFour = strIncreaseFour;
        this.dexIncreaseFour = dexIncreaseFour;
        this.conIncreaseFour = conIncreaseFour;
        this.intIncreaseFour = intIncreaseFour;
        this.wisIncreaseFour = wisIncreaseFour;
        this.chaIncreaseFour = chaIncreaseFour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return o.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, strIncreaseFour, dexIncreaseFour, conIncreaseFour, intIncreaseFour, wisIncreaseFour,
                chaIncreaseFour, userCharacter);
    }
}
