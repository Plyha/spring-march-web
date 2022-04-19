package ru.specialist.spring.service;

public interface CommentService {
    void create(Long postId, String content);
}

