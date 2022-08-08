package pl.coderslab.dragondice.domain;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "backgrounds")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Background {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String backgroundName;
        private String description;
}
