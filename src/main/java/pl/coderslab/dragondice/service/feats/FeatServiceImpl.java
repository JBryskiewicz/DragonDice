package pl.coderslab.dragondice.service.feats;

import pl.coderslab.dragondice.domain.Feats;
import pl.coderslab.dragondice.repository.FeatRepository;

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
