package ua.com.forum.service;

import ua.com.forum.domain.Comment;

public interface CommentService {

    Comment save(Comment comment);

    Comment findById(Long id);

    Comment update(Comment comment);

    void delete(Long id);

}
