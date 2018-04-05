package ua.com.forum.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "themes")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User usersTheme;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "themes_comments",
            joinColumns = @JoinColumn(name = "theme_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    Set<Comment> commentsThemes = new HashSet<>();

}
