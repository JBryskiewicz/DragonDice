package pl.coderslab.dragondice.service.background;

import org.springframework.stereotype.Service;
import pl.coderslab.dragondice.domain.Background;
public interface BackgroundService {
    void saveBackground(Background background);
    void editBackground(Background background);
    void removeBackgroundById(Long id);
}
