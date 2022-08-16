package pl.coderslab.dragondice.service.race;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dragondice.domain.Race;
import pl.coderslab.dragondice.repository.RaceRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public RaceServiceImpl(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public void saveRace(Race race) {
        raceRepository.save(race);
    }
    @Override
    public void editRace(Race race) {
        entityManager.merge(race);
    }
    @Override
    public void removeRace(long id) {
        raceRepository.deleteById(id);
    }
}
