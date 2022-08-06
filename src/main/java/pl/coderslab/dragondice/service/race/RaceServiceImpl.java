package pl.coderslab.dragondice.service.race;

import pl.coderslab.dragondice.domain.Race;
import pl.coderslab.dragondice.repository.RaceRepository;

public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;


    public RaceServiceImpl(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public void saveRace(Race race) {
        raceRepository.save(race);
    }
}
