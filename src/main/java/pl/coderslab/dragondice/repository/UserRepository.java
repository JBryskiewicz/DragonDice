package pl.coderslab.dragondice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.dragondice.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        User findByUserName(String username);
}
