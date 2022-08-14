package pl.coderslab.dragondice.service.scoreIncrease;


import pl.coderslab.dragondice.domain.ScoreIncrease;

public interface ScoreIncreaseService {

    void saveScoreIncrease(ScoreIncrease scoreIncrease);
    void editScoreIncrease(ScoreIncrease scoreIncrease);
    void deleteByUserCharacterId(long id);

}
