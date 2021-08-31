package com.example.postmantest.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter @Setter
@Table(name = "post")
public class Post extends timeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45)
    private String title;

    @Lob
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User writer;

    public void setWriter(User user) {
        if (this.writer != null) {
            this.writer.getPostList().remove(this);
        }
        this.writer = user;
        user.getPostList().add(this);
    }
}
