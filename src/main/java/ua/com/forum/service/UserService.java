package ua.com.forum.service;

import ua.com.forum.domain.User;

public interface UserService {

    User findByEmail(String email);

    User save(User user);

    User update(User user);


}
