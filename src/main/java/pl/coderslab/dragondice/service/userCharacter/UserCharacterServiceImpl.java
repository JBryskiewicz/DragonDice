package pl.coderslab.dragondice.service.userCharacter;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dragondice.domain.UserCharacter;
import pl.coderslab.dragondice.repository.UserCharacterRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class UserCharacterServiceImpl implements UserCharacterService {

    private final UserCharacterRepository userCharacterRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public UserCharacterServiceImpl(UserCharacterRepository userCharacterRepository) {
        this.userCharacterRepository = userCharacterRepository;
    }

    @Override
    public void saveUserCharacter(UserCharacter userCharacter) {
        userCharacterRepository.save(userCharacter);
    }
    @Override
    public void editUserCharacter(UserCharacter userCharacter){
        entityManager.merge(userCharacter);
    }
}
