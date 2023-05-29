package com.portfolio.FullStack.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "Users")
public class User {

    public User (@NotNull String userId){
        this.userId = userId;
    }

    @Column(name = "Username", columnDefinition = "VARCHAR(50)")
    private String username;
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserId", columnDefinition = "VARCHAR(255)")
    private String userId;
    @Transient
    @NotNull
    private String password;
    @Column(name = "Posts", columnDefinition = "JAVA_OBJECT")
    @OneToMany(mappedBy = "postId")
    private ArrayList<Post> posts;
    @Transient
    private Boolean isUsernameEmpty;
    @Transient
    private Boolean isUserIdEmpty;




}
