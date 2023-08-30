package com.example.libraryapp.business.custom;

import com.example.libraryapp.business.BookBAO;
import com.example.libraryapp.business.util.Transformer;
import com.example.libraryapp.dao.BookDAO;
import com.example.libraryapp.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookBO implements BookBAO {
    private final Transformer transformer;
    private final BookDAO bookDAO;

    public BookBO(Transformer transformer, BookDAO bookDAO) {
        this.transformer = transformer;
        this.bookDAO = bookDAO;
    }

    @Override
    public BookDTO saveBook(BookDTO bookDTO) throws Exception {
        System.out.println(transformer.fromBookDTO(bookDTO));
        System.out.println();
        return transformer.toBookDTO(bookDAO.save(transformer.fromBookDTO(bookDTO)));
    }

    @Override
    public List<BookDTO> getAllBooks(String s) throws Exception {
        if (s.isEmpty()){
            System.out.println("s is empty");
            return bookDAO.findAll().stream().map(book -> transformer.toBookDTO(book)).collect(Collectors.toList());
        }
        s="%"+s+"%";
        System.out.println("s is : "+s);
        return bookDAO.findBooksByIsbnLikeOrTitleLikeOrTypeLikeOrAuthorLike(s,s,s,s).stream().map(transformer::toBookDTO).collect(Collectors.toList());

    }
}
