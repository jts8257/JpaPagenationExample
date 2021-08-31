package com.example.postmantest.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter @Setter
public class User extends timeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45)
    private String name;

    @OneToMany(mappedBy = "writer")
    private List<Post> postList = new ArrayList<>();

    @OneToMany(mappedBy = "writer")
    private List<Comment> commentList = new ArrayList<>();

    public void addPost(Post post) {
        if (post.getWriter() != null) {
            post.getWriter().getPostList().remove(post);
        }
        this.getPostList().add(post);
    }

    public void addComment(Comment comment) {
        if (comment.getWriter() != null) {
            comment.getWriter().getPostList().remove(comment);
        }
        this.getCommentList().add(comment);
    }


}
