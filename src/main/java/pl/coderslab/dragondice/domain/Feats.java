package pl.coderslab.dragondice.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "feats")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Feats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String featName;
    private String description;
}
