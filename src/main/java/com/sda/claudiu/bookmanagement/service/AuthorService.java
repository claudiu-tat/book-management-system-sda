package com.sda.claudiu.bookmanagement.service;

import com.sda.claudiu.bookmanagement.model.Author;
import com.sda.claudiu.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.claudiu.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.List;

public interface AuthorService {
    void createAuthor(String firstName, String lastName) throws InvalidParameterException;

    void updateAuthor(int authorId, String firstName, String lastName) throws InvalidParameterException, EntityNotFoundException;

    void deleteAuthor(int authorId) throws InvalidParameterException, EntityNotFoundException;

    List<Author> getAllAuthors();
}
