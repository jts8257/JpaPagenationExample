package com.example.postmantest.mapper;

import com.example.postmantest.domain.Post;
import com.example.postmantest.dto.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper extends GenericMapper<PostDto, Post>{

    @Override
    @Mapping(target = "writer", ignore = true)
    PostDto toDto(Post post);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "writer", ignore = true)
    Post toEntity(PostDto postDto);
}
