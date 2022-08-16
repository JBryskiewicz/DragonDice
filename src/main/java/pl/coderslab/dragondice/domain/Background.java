package pl.coderslab.dragondice.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

import java.util.Objects;

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
        @NotBlank
        private String backgroundName;
        @NotBlank
        @Size(max = 500)
        private String description;

        public Background(String backgroundName, String description){
                this.backgroundName = backgroundName;
                this.description = description;
        }

        public Background cloneWithOriginalId(Background original) {
                return new Background(original.id, backgroundName, description);
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                return o.hashCode() == this.hashCode();
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, backgroundName, description);
        }
}
