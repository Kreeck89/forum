package ua.com.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.forum.domain.Role;
import ua.com.forum.repository.RoleRepository;
import ua.com.forum.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getById(Long id) {
        return roleRepository.findById(id).get();
    }
}
