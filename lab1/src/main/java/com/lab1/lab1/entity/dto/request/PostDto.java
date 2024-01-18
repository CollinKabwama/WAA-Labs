package com.lab1.lab1.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDto {
    String title;
    String content;
    String author;
}
