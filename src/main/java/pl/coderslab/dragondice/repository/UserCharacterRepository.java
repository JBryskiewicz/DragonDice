package pl.coderslab.dragondice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dragondice.domain.UserCharacter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface UserCharacterRepository extends JpaRepository<UserCharacter, Long> {
}
