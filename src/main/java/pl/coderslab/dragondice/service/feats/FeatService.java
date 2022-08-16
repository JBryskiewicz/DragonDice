package pl.coderslab.dragondice.service.feats;

import org.springframework.stereotype.Service;
import pl.coderslab.dragondice.domain.Feats;
public interface FeatService {

    void saveFeat(Feats feats);
    void editFeat(Feats feats);
    void removeFeat(long id);

}
