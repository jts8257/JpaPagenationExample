package com.example.postmantest.mapper;

import com.example.postmantest.domain.Comment;
import com.example.postmantest.domain.Post;
import com.example.postmantest.dto.CommentDto;
import com.example.postmantest.dto.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper extends GenericMapper<CommentDto, Comment>{

    @Override
    @Mapping(target = "writer", ignore = true)
    CommentDto toDto(Comment comment);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "writer", ignore = true)
    Comment toEntity(CommentDto commentDto);


    /**
    @Mapping(target = "writer", ignore = true)
    PostDto toDto(Post post);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "writer", ignore = true)
    Post toEntity(PostDto postDto);
    **/

}
