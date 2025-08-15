package com.spring.boot.universitycoursemanagmentsystem.controller.lec11.controller;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec11.dto.PostDto;
import com.spring.boot.universitycoursemanagmentsystem.Service.lec11.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class PostController {

    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    ResponseEntity<PostDto> createPost(@RequestBody @Valid PostDto postDto){
        return  ResponseEntity.ok(postService.createPost(postDto));
    }

    @GetMapping("posts/postWithUsers/{id}")
    ResponseEntity<PostDto> getPostById(@PathVariable Long id){
        return  ResponseEntity.ok(postService.getPostById(id));

    }

     @GetMapping("posts/postsWithUsers")
    ResponseEntity<List<PostDto>> getAllPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PutMapping("posts/{id}")
    ResponseEntity<PostDto> updatePost(@PathVariable Long id , @RequestBody @Valid PostDto postDto){
        return  ResponseEntity.ok(postService.updatePost(id, postDto));

    }


    @DeleteMapping("posts/{id}")
    ResponseEntity<Void>deletePostById(@PathVariable Long id){
        if(Objects.nonNull(id)){
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }
}
