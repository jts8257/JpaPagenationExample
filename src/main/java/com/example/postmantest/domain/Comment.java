package com.example.postmantest.domain;

import com.example.postmantest.enums.CommentStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Comment extends timeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User writer;

    @Column(length = 255)
    private String content;

    private CommentStatus commentStatus;

    public void setWriter(User user) {
        if (this.writer != null) {
            this.writer.getCommentList().remove(this);
        }
        this.writer = user;
        user.getCommentList().add(this);
    }
}
