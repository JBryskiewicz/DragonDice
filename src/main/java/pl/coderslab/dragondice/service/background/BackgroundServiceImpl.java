package pl.coderslab.dragondice.service.background;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dragondice.domain.Background;
import pl.coderslab.dragondice.repository.BackgroundRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class BackgroundServiceImpl implements BackgroundService{

    private final BackgroundRepository backgroundRepository;
    @PersistenceContext
    private EntityManager entityManager;


    public BackgroundServiceImpl(BackgroundRepository backgroundRepository) {
        this.backgroundRepository = backgroundRepository;
    }

    @Override
    public void saveBackground(Background background) {
        backgroundRepository.save(background);
    }
    @Override
    public void editBackground(Background background) {
        entityManager.merge(background);
    }
    @Override
    public void removeBackgroundById(Long id) {
        backgroundRepository.deleteById(id);
    }
}
