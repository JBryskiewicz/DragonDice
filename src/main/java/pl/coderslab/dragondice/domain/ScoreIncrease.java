package pl.coderslab.dragondice.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScoreIncrease {

    /* This class is presentation of possibility, it is most likely much more efficient to split it into separate
    classes with one character to many score increases relation, but upcoming deadline makes me unable to redo it
    again */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private UserCharacter userCharacter;
    private int strIncreaseFour;
    private int dexIncreaseFour;
    private int conIncreaseFour;
    private int intIncreaseFour;
    private int wisIncreaseFour;
    private int chaIncreaseFour;
    private int strIncreaseEight;
    private int dexIncreaseEight;
    private int conIncreaseEight;
    private int intIncreaseEight;
    private int wisIncreaseEight;
    private int chaIncreaseEight;


    public ScoreIncrease(int strIncreaseFour, int dexIncreaseFour, int conIncreaseFour, int intIncreaseFour, int wisIncreaseFour, int chaIncreaseFour,
    int strIncreaseEight, int dexIncreaseEight, int conIncreaseEight, int intIncreaseEight, int wisIncreaseEight, int chaIncreaseEight ) {
        this.strIncreaseFour = strIncreaseFour;
        this.dexIncreaseFour = dexIncreaseFour;
        this.conIncreaseFour = conIncreaseFour;
        this.intIncreaseFour = intIncreaseFour;
        this.wisIncreaseFour = wisIncreaseFour;
        this.chaIncreaseFour = chaIncreaseFour;
        this.strIncreaseEight = strIncreaseEight;
        this.dexIncreaseEight = dexIncreaseEight;
        this.conIncreaseEight = conIncreaseEight;
        this.intIncreaseEight = intIncreaseEight;
        this.wisIncreaseEight = wisIncreaseEight;
        this.chaIncreaseEight = chaIncreaseEight;
    }

    public ScoreIncrease cloneWithOriginalId(ScoreIncrease original) {
        return new ScoreIncrease(original.id, original.userCharacter, strIncreaseFour, dexIncreaseFour, conIncreaseFour, intIncreaseFour,
                wisIncreaseFour, chaIncreaseFour, strIncreaseEight, dexIncreaseEight, conIncreaseEight,
                intIncreaseEight, wisIncreaseEight, chaIncreaseEight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return o.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userCharacter, strIncreaseFour, dexIncreaseFour, conIncreaseFour, intIncreaseFour, wisIncreaseFour,
                chaIncreaseFour, strIncreaseEight, dexIncreaseEight, conIncreaseEight, intIncreaseEight,
               wisIncreaseEight, chaIncreaseEight);
    }
}
