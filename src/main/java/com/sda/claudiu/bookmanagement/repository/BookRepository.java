package com.sda.claudiu.bookmanagement.repository;

import com.sda.claudiu.bookmanagement.model.Book;

import java.util.Optional;

public interface BookRepository extends BaseRepository<Book> {
   // Optional<Book> findByTitle(String title);
}
