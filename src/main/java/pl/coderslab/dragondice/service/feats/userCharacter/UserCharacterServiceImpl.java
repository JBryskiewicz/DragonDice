package pl.coderslab.dragondice.service.feats.userCharacter;

import org.springframework.stereotype.Service;
import pl.coderslab.dragondice.domain.UserCharacter;
import pl.coderslab.dragondice.repository.UserCharacterRepository;

@Service
public class UserCharacterServiceImpl implements UserCharacterService{

    private final UserCharacterRepository userCharacterRepository;

    public UserCharacterServiceImpl(UserCharacterRepository userCharacterRepository) {
        this.userCharacterRepository = userCharacterRepository;
    }

    @Override
    public void saveUserCharacter(UserCharacter userCharacter) {
        userCharacterRepository.save(userCharacter);
    }
}
