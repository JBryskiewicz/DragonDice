package pl.coderslab.dragondice.service.scoreIncrease;


import pl.coderslab.dragondice.domain.ScoreIncrease;
import pl.coderslab.dragondice.domain.UserCharacter;

public interface ScoreIncreaseService {

    void saveScoreIncrease(ScoreIncrease scoreIncrease);
    void editScoreIncrease(ScoreIncrease scoreIncrease);

}
