package com.sda.claudiu.bookmanagement.service;

import com.sda.claudiu.bookmanagement.model.BookReview;
import com.sda.claudiu.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.claudiu.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.List;

public interface BookReviewService {
    void createBookReview(String bookTitle, int score, String comment) throws InvalidParameterException, EntityNotFoundException;
    List<BookReview> viewAllReviews();
    List<BookReview> viewAllReviewOfAGivenBook(String title) throws InvalidParameterException, EntityNotFoundException;
}
