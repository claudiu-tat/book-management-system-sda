package com.sda.claudiu.bookmanagement.repository;
import com.sda.claudiu.bookmanagement.model.BookReview;

import java.util.List;


public interface BookReviewRepository extends BaseRepository<BookReview>{
    List<BookReview> findReviewsByAGivenTitle(String title);
}
