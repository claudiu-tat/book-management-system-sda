package com.sda.claudiu.bookmanagement.service;

import com.sda.claudiu.bookmanagement.model.Book;
import com.sda.claudiu.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.claudiu.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.List;

public interface BookService {
    void createBook(String title, String description, int authorId) throws InvalidParameterException, EntityNotFoundException;
    void updateBook(int bookId, String bookTitle, String description, int authorId) throws InvalidParameterException, EntityNotFoundException;
    void deleteBook(int bookId) throws InvalidParameterException, EntityNotFoundException;
    List<Book> getAllBooks();
}
