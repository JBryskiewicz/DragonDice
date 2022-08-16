package pl.coderslab.dragondice.service.feats;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dragondice.domain.Feats;
import pl.coderslab.dragondice.repository.FeatRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class FeatServiceImpl implements FeatService{

    private final FeatRepository featRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public FeatServiceImpl(FeatRepository featRepository) {
        this.featRepository = featRepository;
    }

    @Override
    public void saveFeat(Feats feats) {
        featRepository.save(feats);
    }

    @Override
    public void editFeat(Feats feats) {
        entityManager.merge(feats);
    }

    @Override
    public void removeFeat(long id) {
        featRepository.deleteById(id);
    }
}
