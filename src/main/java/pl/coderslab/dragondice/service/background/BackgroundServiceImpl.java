package pl.coderslab.dragondice.service.background;

import pl.coderslab.dragondice.domain.Background;
import pl.coderslab.dragondice.repository.BackgroundRepository;

public class BackgroundServiceImpl implements BackgroundService{

    private final BackgroundRepository backgroundRepository;

    public BackgroundServiceImpl(BackgroundRepository backgroundRepository) {
        this.backgroundRepository = backgroundRepository;
    }

    @Override
    public void save(Background background) {
        backgroundRepository.save(background);
    }
}
