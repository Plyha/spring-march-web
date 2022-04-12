package ru.specialist.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.specialist.spring.entity.Post;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitleIgnoreCase(String title);

    List<Post> findByDtCreatedBetween(LocalDateTime start, LocalDateTime end);

    List<Post> findByUser_Username(String username);

    List<Post> findByContentContainingIgnoreCase(String substring);
}
