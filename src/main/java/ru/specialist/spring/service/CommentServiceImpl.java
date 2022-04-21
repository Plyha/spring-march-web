package ru.specialist.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.specialist.spring.entity.Comment;
import ru.specialist.spring.entity.Post;
import ru.specialist.spring.entity.User;
import ru.specialist.spring.repository.CommentRepository;
import ru.specialist.spring.repository.PostRepository;
import ru.specialist.spring.repository.UserRepository;

import java.time.LocalDateTime;

import static ru.specialist.spring.util.SecurityUtils.getCurrentUserDetails;


@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(PostRepository postRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void create(Long postId, String content) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setDtCreated(LocalDateTime.now());

        Post post = postRepository.findById(postId).orElseThrow();
        comment.setPost(post);

        User user = userRepository.findByUsername(
                getCurrentUserDetails().getUsername()).orElseThrow();
        comment.setUser(user);
        commentRepository.save(comment);
    }
}
