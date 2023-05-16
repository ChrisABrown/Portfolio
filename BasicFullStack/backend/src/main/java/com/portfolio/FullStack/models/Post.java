package com.portfolio.FullStack.models;

import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;

public class Post {
    User user;
    LocalDateTime createdOn;
    LocalDateTime updatedOn;
    String body;
    Comment[] comments;

    public boolean isEmpty() {
        return body == null || body.equals("");
    }
}
