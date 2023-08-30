package com.example.libraryapp.business.util;

import com.example.libraryapp.dto.BookDTO;
import com.example.libraryapp.dto.UserDTO;
import com.example.libraryapp.entity.Book;
import com.example.libraryapp.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Transformer {
    private final ModelMapper mapper = new ModelMapper();
    public BookDTO toBookDTO(Book book){
        BookDTO map = mapper.map(book, BookDTO.class);
        return map;
    }
    public Book fromBookDTO(BookDTO bookDTO){
        Book map = mapper.map(bookDTO, Book.class);
        return map;
    }

    public UserDTO toUserDTO(User user){
        UserDTO map = mapper.map(user, UserDTO.class);
        return map;
    }
    public User fromUserDTO(UserDTO userDto){
        User map = mapper.map(userDto, User.class);
        return map;
    }
}
