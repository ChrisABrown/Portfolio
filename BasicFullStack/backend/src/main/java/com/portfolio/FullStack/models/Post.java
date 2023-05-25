package com.portfolio.FullStack.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "Posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "PostId")
    private String postId;
    @JoinColumn(name = "UserId")
    @Transient
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @Column(name = "CreatedOn")
    private LocalDateTime createdOn;
    @Column(name = "UpdatedOn")
    private LocalDateTime updatedOn;
    @Column(name = "Body")
    private String body;
    @Column(name = "Comments")
    @Transient
    private Comment[] comments;

    public Post(@NotNull String postId) {
        this.postId = postId;
    }

    public boolean isEmpty() {
        return body == null || body.equals("");
    }


}
