package ru.specialist.spring.service;

import ru.specialist.spring.dto.PostDto;
import ru.specialist.spring.entity.Post;

public interface PostService {
    void create(PostDto postDto);

    Post findById(Long postId);
}
