package pl.coderslab.dragondice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.dragondice.domain.UserCharacter;

public interface UserCharacterRepository extends JpaRepository<UserCharacter, Long> {

}
