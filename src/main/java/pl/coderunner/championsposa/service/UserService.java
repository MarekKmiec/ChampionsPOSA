package pl.coderunner.championsposa.service;

import pl.coderunner.championsposa.domain.User;

public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);
}
