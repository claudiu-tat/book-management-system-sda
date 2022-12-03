package com.sda.claudiu.bookmanagement.repository;

import com.sda.claudiu.bookmanagement.model.Book;
import com.sda.claudiu.bookmanagement.model.BookReview;
import com.sda.claudiu.bookmanagement.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class BookReviewRepositoryImpl extends BaseRepositoryImpl<BookReview> implements BookReviewRepository{
    public BookReviewRepositoryImpl() {
        super(BookReview.class);
    }
}
