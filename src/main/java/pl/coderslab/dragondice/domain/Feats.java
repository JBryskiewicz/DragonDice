package pl.coderslab.dragondice.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

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
    private long id;
    @NotNull
    private String featName;
    @NotNull
    private String description;

    public Feats(String featName, String description){
        this.featName = featName;
        this.description = description;
    }

    public Feats cloneWithOriginalId(Feats original){
        return new Feats(original.id, featName, description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return o.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, featName, description);
    }
}
