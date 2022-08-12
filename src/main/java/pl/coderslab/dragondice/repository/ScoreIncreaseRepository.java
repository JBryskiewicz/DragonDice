package pl.coderslab.dragondice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.dragondice.domain.ScoreIncrease;

import java.util.List;

@Repository
public interface ScoreIncreaseRepository extends JpaRepository<ScoreIncrease, Long> {

    @Query(value = "select * from score_increase join playable_characters_score_increases pcsi" +
            " on score_increase.id = pcsi.score_increases_id where pcsi.user_character_id = ?1", nativeQuery = true)
    List<ScoreIncrease> findAllByCharacterId(long id);

}
