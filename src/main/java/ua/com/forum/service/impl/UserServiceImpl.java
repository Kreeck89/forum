package ua.com.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.forum.domain.User;
import ua.com.forum.repository.UserRepository;
import ua.com.forum.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }
}
