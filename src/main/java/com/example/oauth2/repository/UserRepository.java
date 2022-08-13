package com.example.oauth2.repository;


import com.example.oauth2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "insert into users(name,given_name,picture,type,email,login,bio,avatar_url,url) VALUES(?,?,?,?,?,?,?,?,?)",nativeQuery = true)
    int insertInToUser(String name,
                       String given_name,
                       String picture,
                       String type,
                       String email,
                       String login,
                       String bio,
                       String avatar_url,
                       String url);
}
