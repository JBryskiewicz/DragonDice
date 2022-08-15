package pl.coderslab.dragondice.mechanics;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.coderslab.dragondice.domain.ScoreIncrease;
import pl.coderslab.dragondice.domain.UserCharacter;
import pl.coderslab.dragondice.repository.ScoreIncreaseRepository;
import pl.coderslab.dragondice.repository.UserCharacterRepository;

public class AbilityScoreSum {

    private final UserCharacterRepository userCharacterRepository;
    private final ScoreIncreaseRepository scoreIncreaseRepository;

    public AbilityScoreSum(UserCharacterRepository userCharacterRepository, ScoreIncreaseRepository scoreIncreaseRepository){
        this.userCharacterRepository = userCharacterRepository;
        this.scoreIncreaseRepository = scoreIncreaseRepository;
    }

    private UserCharacter findCharacter(long id){
        return userCharacterRepository.findById(id).get();
    }
    private ScoreIncrease findScoreIncrease(long id){
        return scoreIncreaseRepository.findByCharacterId(id).get();
    }

    public int strAbilityScore(long id){
        UserCharacter userCharacter = findCharacter(id);
        ScoreIncrease scoreIncrease = findScoreIncrease(id);
        return userCharacter.getStrAbility() + scoreIncrease.getStrIncreaseFour() + scoreIncrease.getStrIncreaseEight();
    }

    public int dexAbilityScore(long id){
        UserCharacter userCharacter = findCharacter(id);
        ScoreIncrease scoreIncrease = findScoreIncrease(id);
        return userCharacter.getDexAbility() + scoreIncrease.getDexIncreaseFour() + scoreIncrease.getDexIncreaseEight();
    }

    public int conAbilityScore(long id){
        UserCharacter userCharacter = findCharacter(id);
        ScoreIncrease scoreIncrease = findScoreIncrease(id);
        return userCharacter.getConAbility() + scoreIncrease.getConIncreaseFour() + scoreIncrease.getConIncreaseEight();
    }

    public int intAbilityScore(long id){
        UserCharacter userCharacter = findCharacter(id);
        ScoreIncrease scoreIncrease = findScoreIncrease(id);
        return userCharacter.getIntAbility() + scoreIncrease.getIntIncreaseFour() + scoreIncrease.getIntIncreaseEight();
    }

    public int wisAbilityScore(long id){
        UserCharacter userCharacter = findCharacter(id);
        ScoreIncrease scoreIncrease = findScoreIncrease(id);
        return userCharacter.getWisAbility() + scoreIncrease.getWisIncreaseFour() + scoreIncrease.getWisIncreaseEight();
    }

    public int chaAbilityScore(long id){
        UserCharacter userCharacter = findCharacter(id);
        ScoreIncrease scoreIncrease = findScoreIncrease(id);
        return userCharacter.getChaAbility() + scoreIncrease.getChaIncreaseFour() + scoreIncrease.getChaIncreaseEight();
    }


}
