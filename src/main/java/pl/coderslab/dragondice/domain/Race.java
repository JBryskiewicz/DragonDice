package pl.coderslab.dragondice.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "races")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String raceName;
    @NotBlank
    @Size(max = 500)
    private String raceFeatures;
    @Min(0)
    @NotNull
    private int raceWalkingSpeed;

    public Race(String raceName, String raceFeatures, int raceWalkingSpeed){
        this.raceName = raceName;
        this.raceFeatures = raceFeatures;
        this.raceWalkingSpeed = raceWalkingSpeed;
    }
    public Race cloneWithOriginalId(Race original){
        return new Race(original.id, raceName, raceFeatures, raceWalkingSpeed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return o.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, raceName, raceFeatures, raceWalkingSpeed);
    }
}
