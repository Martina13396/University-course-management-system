package com.spring.boot.universitycoursemanagmentsystem.Service.lec11.service;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec11.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostDto getPostById(Long id);

    List<PostDto> getAllPosts();

    PostDto updatePost(Long id , PostDto postDto);

    void deletePostById(Long id);

}
