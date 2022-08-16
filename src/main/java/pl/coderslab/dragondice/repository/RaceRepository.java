package pl.coderslab.dragondice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.dragondice.domain.Race;

public interface RaceRepository extends JpaRepository<Race, Long> {

}
