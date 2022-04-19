package ru.specialist.spring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {

    private String title;
    private String content;
    private String tags;
}
