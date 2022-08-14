package pl.coderslab.dragondice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.dragondice.domain.ScoreIncrease;

import java.util.Optional;

@Repository
public interface ScoreIncreaseRepository extends JpaRepository<ScoreIncrease, Long> {
    @Query("select si from ScoreIncrease si where si.userCharacter.id = ?1")
    Optional<ScoreIncrease> findByCharacterId(long id);
    void deleteByUserCharacterId(long id);
}
