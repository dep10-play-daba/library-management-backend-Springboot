package com.example.libraryapp.dao;

import com.example.libraryapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends JpaRepository<User,Integer> {
    List<User> findUserByUserIdLikeOrNameLikeOrContactLike(int id,String name,String contact)throws Exception;
    Optional<User> findByName(String string);
}
