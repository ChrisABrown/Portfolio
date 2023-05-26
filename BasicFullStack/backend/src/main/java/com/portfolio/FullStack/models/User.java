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

    @Column(name = "Username")
    private String username;
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;
    @Transient
    @NotNull
    private String password;
    @Column(name = "Posts")
    @Transient
    private ArrayList<Post> posts;
    private Boolean isUsernameEmpty;
    private Boolean isUserIdEmpty;


}
