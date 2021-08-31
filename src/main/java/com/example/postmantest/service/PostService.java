package com.example.postmantest.service;

import com.example.postmantest.domain.Post;
import com.example.postmantest.dto.PostDto;
import com.example.postmantest.mapper.PostMapper;
import com.example.postmantest.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public List<PostDto> searchPost(Pageable pageable) {
        List<PostDto> postDtoList = new ArrayList<>();
        Page<Post> postPage = postRepository.findAll(pageable);

        for (Post elementPost : postPage.getContent()){
            postDtoList.add(ConvertToDto(elementPost));
        }
        return postDtoList;
    }

    public List<PostDto> searchNativeQuery(Pageable pageable) {
        List<PostDto> postDtoList = new ArrayList<>();
        Page<Post> postPage = postRepository.nativeQuery(pageable);

        for (Post elementPost : postPage.getContent()){
            postDtoList.add(ConvertToDto(elementPost));
        }
        return postDtoList;
    }

    private PostDto ConvertToDto(Post post) {
        PostDto dto = postMapper.toDto(post);
        dto.setWriter(post.getWriter().getName());
        return dto;
    }

}
