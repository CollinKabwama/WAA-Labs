package com.lab1.lab1.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    public static Long count = 1l;

    Long id;
    String title;
    String content;
    String author;



}