package ua.com.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.forum.domain.Theme;
import ua.com.forum.repository.ThemeRepository;
import ua.com.forum.service.ThemeService;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public List<Theme> getAll() {
        return themeRepository.findAll();
    }

    @Override
    public Theme findById(Long id) {
        Optional<Theme> byId = themeRepository.findById(id);
        return byId.get();
    }

    @Override
    public Theme save(Theme theme) {
        return themeRepository.save(theme);
    }

    @Override
    public Theme update(Theme theme) {
        return themeRepository.saveAndFlush(theme);
    }

    @Override
    public void delete(Long id) {
        themeRepository.deleteById(id);
    }
}
