package ru.specialist.spring.service;

import ru.specialist.spring.entity.Tag;

public interface TagService {

    void createTag(String name);

    void createTags(String... names);

    Tag findByName(String tagName);
}
