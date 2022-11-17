package com.sda.claudiu.bookmanagement.service;

import com.sda.claudiu.bookmanagement.service.exceptions.InvalidParameterException;

public interface AuthorService {
    void createAuthor(String firstName, String lastName) throws InvalidParameterException;
}
