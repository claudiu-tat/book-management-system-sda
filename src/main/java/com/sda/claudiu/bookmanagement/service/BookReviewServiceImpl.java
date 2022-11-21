package com.sda.claudiu.bookmanagement.service;

import com.sda.claudiu.bookmanagement.model.Book;
import com.sda.claudiu.bookmanagement.model.BookReview;
import com.sda.claudiu.bookmanagement.repository.BookRepository;
import com.sda.claudiu.bookmanagement.repository.BookReviewRepository;
import com.sda.claudiu.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.claudiu.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.Optional;

public class BookReviewServiceImpl implements BookReviewService {
    private final BookReviewRepository bookReviewRepository;
    private final BookRepository bookRepository;

    public BookReviewServiceImpl(BookReviewRepository bookReviewRepository, BookRepository bookRepository) {
        this.bookReviewRepository = bookReviewRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void createBookReview(String bookTitle, int score, String comment) throws InvalidParameterException, EntityNotFoundException {
        if (bookTitle == null || bookTitle.isBlank() || bookTitle.length() < 3) {
            throw new InvalidParameterException("Provided value for book title: " + bookTitle + " is invalid!");
        }
        if (comment == null || comment.isBlank() || comment.length() < 10) {
            throw new InvalidParameterException("Provided value for comment: " + comment + " is invalid!");
        }
        if (score < 1 || score > 5) {
            throw new InvalidParameterException("Provided value for score: " + score + " is invalid!");
        }

        Optional<Book> bookOptional = bookRepository.findByTitle(bookTitle);
        if (bookOptional.isEmpty()) {
            throw new EntityNotFoundException("Book not found for title: " + bookTitle);
        }

        Book book = bookOptional.get();
        BookReview bookReview = new BookReview(score,comment);
        bookReview.setBook(book);

        bookReviewRepository.create(bookReview);
    }
}
