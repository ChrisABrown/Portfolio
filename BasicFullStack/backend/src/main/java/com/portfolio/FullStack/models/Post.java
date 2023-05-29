package com.portfolio.FullStack.models;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "Posts")
public class Post {

    public Post (@NotNull String postId){
        this.postId = postId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "PostId", columnDefinition = "VARCHAR(255)")
    private String postId;
    @JoinColumn(name = "User", columnDefinition = "VARCHAR(50)")
    @ManyToOne
    private User user;
    @Column(name = "CreatedOn", columnDefinition = "DATETIME")
    private LocalDateTime createdOn;
    @Column(name = "UpdatedOn", columnDefinition = "DATETIME")
    private LocalDateTime updatedOn;
    @Column(name = "Body", columnDefinition = "TEXT")
    private String body;



    public boolean isEmpty() {
        return body == null || body.equals("");
    }


}
