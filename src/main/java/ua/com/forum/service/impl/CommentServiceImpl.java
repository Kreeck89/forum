package ua.com.forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.forum.domain.Comment;
import ua.com.forum.repository.CommentRepository;
import ua.com.forum.service.CommentService;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment findById(Long id) {
        Optional<Comment> byId = commentRepository.findById(id);
        return byId.get();
    }

    @Override
    public Comment update(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
