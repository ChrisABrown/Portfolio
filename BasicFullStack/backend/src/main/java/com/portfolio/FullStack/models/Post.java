package com.portfolio.FullStack.models;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Post {

    String postId;
    User user;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    String body;
    Comment[] comments;

    static @NotNull String usingRandomUUID(){
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("_", "").substring(0,6);
    }
    public boolean isEmpty() {
        return body == null || body.equals("");
    }


    public void setPostId(){
        this.postId = usingRandomUUID();
    }
}
