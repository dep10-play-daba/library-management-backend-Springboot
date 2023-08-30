package com.example.libraryapp.business;

import com.example.libraryapp.dto.BookDTO;

import java.io.Serializable;
import java.util.List;

public interface BookBAO {
  BookDTO saveBook(BookDTO bookDTO) throws Exception;
  List<BookDTO> getAllBooks(String s)throws Exception;
}
