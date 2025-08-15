package com.spring.boot.universitycoursemanagmentsystem.lec9.mapper.lec11.mapper;

import com.spring.boot.universitycoursemanagmentsystem.Service.lec11.dto.PostDto;
import com.spring.boot.universitycoursemanagmentsystem.model.lec11.model.Post;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post toPost(PostDto postDto);
    PostDto toPostDto(Post post);

    List<Post> toPostList(List<PostDto> postDtos);

    List<PostDto> toPostDtoList(List<Post> posts);
}
