package com.example.libraryapp.dao;

import com.example.libraryapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDAO extends JpaRepository<Book,String>{
    List<Book> findBooksByIsbnLikeOrTitleLikeOrTypeLikeOrAuthorLike(String isbn,String title,String type,String author)throws Exception;

}
