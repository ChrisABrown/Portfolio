package com.portfolio.FullStack.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Posts")
public class Post {

    String postId;
    @Id
    User user;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    String body;
    Comment[] comments;

    static @NotNull String usingRandomUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("_", "").substring(0, 6);
    }

    public boolean isEmpty() {
        return body == null || body.equals("");
    }


    public void setPostId() {
        this.postId = usingRandomUUID();
    }
}
