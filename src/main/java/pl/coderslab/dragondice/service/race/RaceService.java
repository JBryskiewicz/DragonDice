package pl.coderslab.dragondice.service.race;


import org.springframework.stereotype.Service;
import pl.coderslab.dragondice.domain.Race;
public interface RaceService {

    void saveRace(Race race);

    void editRace(Race race);
    void removeRace(long id);
}
