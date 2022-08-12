package pl.coderslab.dragondice.service.scoreIncrease;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dragondice.domain.ScoreIncrease;
import pl.coderslab.dragondice.domain.UserCharacter;
import pl.coderslab.dragondice.repository.ScoreIncreaseRepository;
import pl.coderslab.dragondice.repository.UserCharacterRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class ScoreIncreaseServiceImpl implements ScoreIncreaseService{

    public ScoreIncreaseRepository scoreIncreaseRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public ScoreIncreaseServiceImpl(ScoreIncreaseRepository scoreIncreaseRepository) {
        this.scoreIncreaseRepository = scoreIncreaseRepository;
    }

    @Override
    public void saveScoreIncrease(ScoreIncrease scoreIncrease) {
        scoreIncreaseRepository.save(scoreIncrease);
    }
    @Override
    public void editScoreIncrease(ScoreIncrease scoreIncrease) {
        entityManager.merge(scoreIncrease);
    }
}
