package ua.com.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.forum.domain.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
}
