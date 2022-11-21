package com.sda.claudiu.bookmanagement.service;

import com.sda.claudiu.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.claudiu.bookmanagement.service.exceptions.InvalidParameterException;

public interface BookReviewService {
    void createBookReview(String bookTitle, int score, String comment) throws InvalidParameterException, EntityNotFoundException;
}
