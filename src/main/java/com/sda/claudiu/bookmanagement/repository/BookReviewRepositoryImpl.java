package com.sda.claudiu.bookmanagement.repository;

import com.sda.claudiu.bookmanagement.model.BookReview;
import com.sda.claudiu.bookmanagement.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class BookReviewRepositoryImpl extends BaseRepositoryImpl<BookReview> implements BookReviewRepository{
    public BookReviewRepositoryImpl() {
        super(BookReview.class);
    }
    @Override
    public List<BookReview> findReviewsByAGivenTitle(String title) {
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            String selectAllReviews = "FROM BookReview b WHERE b.comment = :bookReview";
            Query<BookReview> query = session.createQuery(selectAllReviews);
            query.setParameter("bookReview", title);
            List<BookReview> bookReviews = query.list();
            if (!bookReviews.isEmpty()) {
                return List.of(bookReviews.get(0));
            } else {
                return new ArrayList();
            }
        }
    }
}
