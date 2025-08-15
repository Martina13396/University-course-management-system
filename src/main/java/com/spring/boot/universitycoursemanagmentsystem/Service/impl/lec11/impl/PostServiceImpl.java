package com.spring.boot.universitycoursemanagmentsystem.Service.impl.lec11.impl;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec11.dto.PostDto;
import com.spring.boot.universitycoursemanagmentsystem.Service.lec11.service.PostService;
import com.spring.boot.universitycoursemanagmentsystem.lec9.mapper.lec11.mapper.PostMapper;
import com.spring.boot.universitycoursemanagmentsystem.model.lec11.model.Post;
import com.spring.boot.universitycoursemanagmentsystem.repo.lec11.repo.PostRepo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    PostMapper postMapper;
    PostRepo postRepo;
    @Override
    public PostDto createPost(PostDto postDto) {
      if (Objects.nonNull(postDto)) {
          throw new RuntimeException("id must be null");
      }
      Post post = postMapper.toPost(postDto);
      postRepo.save(post);
      postDto.setId(post.getId());
      return postDto;
    }

    @Override
    public PostDto getPostById(Long id) {
       Optional<Post> postOptional = postRepo.findById(id);
       if (!postOptional.isPresent()) {
           throw new RuntimeException("Post not found");
       }
       return postMapper.toPostDto(postOptional.get());
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepo.findAll();
        if(CollectionUtils.isEmpty(posts)) {
            return new ArrayList<>();
        }
        return posts.stream().map(post ->  postMapper.toPostDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto updatePost(Long id,PostDto postDto) {
        Optional<Post> postOptional = postRepo.findById(id);
        if (!postOptional.isPresent()) {
            throw new RuntimeException("Post not found");
        }
        if(Objects.isNull(postDto.getId())) {
            throw new RuntimeException("id can not be null");
        }
        Post post = postMapper.toPost(postDto);
        post.setId(id);
        postRepo.save(post);
        return postDto;

    }

    @Override
    public void deletePostById(Long id) {

        postRepo.deleteById(id);

    }
}
