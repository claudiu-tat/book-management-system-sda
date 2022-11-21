package com.sda.claudiu.bookmanagement.repository;

import com.sda.claudiu.bookmanagement.model.Book;
import com.sda.claudiu.bookmanagement.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book> implements BookRepository {
    public BookRepositoryImpl() {
        super(Book.class);   // aici nu ma era nevoie de parametrizare deoarece aici cunoastem cu ce entitate lucram, adica cu book
    }
    @Override
    public Optional<Book> findByTitle(String title) {
        try (Session session = SessionManager.getSessionFactory().openSession()) {
            Query<Book> query = session.createQuery("FROM Book b WHERE b.title = :bookTitle", Book.class);      // bookTitle is the parameter. Here is a query parametrised and the bookTitle is like ? in jdbc
            query.setParameter("bookTitle", title);
            List<Book> books = query.list();
            if (!books.isEmpty()) {
                return Optional.of(books.get(0));
            } else {
                return Optional.empty();
            }
        }
    }
}
