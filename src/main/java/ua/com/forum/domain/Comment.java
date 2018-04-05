package ua.com.forum.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment implements Comparable<Object> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "comments")
    private Set<User> usersComments = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "commentsThemes")
    private Set<Theme> themesComments = new HashSet<>();

    @Override
    public int compareTo(Object comment) {
        Comment comment1 = (Comment) comment;
        return this.getName().compareTo(comment1.name);
    }
}
