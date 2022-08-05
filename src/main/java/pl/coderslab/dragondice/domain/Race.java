package pl.coderslab.dragondice.domain;

import lombok.*;

import javax.persistence.*;

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
    private int id;
    private String raceName;
    private String raceFeatures;
}
