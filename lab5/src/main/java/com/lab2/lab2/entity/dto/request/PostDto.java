package com.lab2.lab2.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDto {
    String title;
    String content;
    String author;
}
