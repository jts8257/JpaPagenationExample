package com.example.postmantest;


import com.example.postmantest.domain.Post;
import com.example.postmantest.domain.User;
import com.example.postmantest.dto.PostDto;
import com.example.postmantest.repository.PostRepository;
import com.example.postmantest.repository.UserRepository;
import com.example.postmantest.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BaseController {

    private final PostService postService;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @GetMapping("/posts")
    public List<PostDto> searchPost(Pageable pageable) {

        return postService.searchPost(pageable);
    }

    @GetMapping("/posts2")
    public List<PostDto> searchPost2(Pageable pageable) {

        return postService.searchNativeQuery(pageable);
    }

    @PostConstruct
    public void baseSetting() {
        User user = new User();
        user.setName("tymothy jeong");
        userRepository.save(user);

        for (int i = 0 ; i < 100 ; i++) {
            Post post = new Post();
            post.setWriter(user);
            post.setTitle("title " + i);
            post.setContent("content" + i);
            postRepository.save(post);
        }
    }
}
