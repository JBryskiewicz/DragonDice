package pl.coderslab.dragondice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.dragondice.domain.Background;

public interface BackgroundRepository extends JpaRepository<Background, Long> {
}
