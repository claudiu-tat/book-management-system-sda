package com.sda.claudiu.bookmanagement.service;

import com.sda.claudiu.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.claudiu.bookmanagement.service.exceptions.InvalidParameterException;

public interface BookService {
    void createBook(String title, String description, int authorId) throws InvalidParameterException, EntityNotFoundException;
}
