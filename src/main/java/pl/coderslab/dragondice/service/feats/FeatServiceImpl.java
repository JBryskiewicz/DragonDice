package pl.coderslab.dragondice.service.feats;

import org.springframework.stereotype.Service;
import pl.coderslab.dragondice.domain.Feats;
import pl.coderslab.dragondice.repository.FeatRepository;
@Service
public class FeatServiceImpl implements FeatService{

    private final FeatRepository featRepository;

    public FeatServiceImpl(FeatRepository featRepository) {
        this.featRepository = featRepository;
    }

    @Override
    public void save(Feats feats) {
        featRepository.save(feats);
    }
}
