package pl.coderslab.dragondice.service.user;

import pl.coderslab.dragondice.domain.User;

public interface UserService {

    User findByUserName(String name);
    void saveUser(User user);

}
