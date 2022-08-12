package pl.coderslab.dragondice.domain;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

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
}
