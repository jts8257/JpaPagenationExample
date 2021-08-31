package com.example.postmantest.repository;

import com.example.postmantest.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM post p",
    countQuery = "SELECT count(*) FROM post p",
    nativeQuery = true)
    Page<Post> nativeQuery(Pageable pageable);

}
