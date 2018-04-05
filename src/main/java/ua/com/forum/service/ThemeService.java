package ua.com.forum.service;

import ua.com.forum.domain.Theme;

import java.util.List;

public interface ThemeService {

    List<Theme> getAll();

    Theme findById(Long id);

    Theme save(Theme theme);

    Theme update(Theme theme);

    void delete(Long id);
}
