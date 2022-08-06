package pl.coderslab.dragondice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.dragondice.domain.Feats;

public interface FeatRepository extends JpaRepository<Feats, Long> {

}
