package com.sda.claudiu.bookmanagement.service;

import com.sda.claudiu.bookmanagement.model.Author;
import com.sda.claudiu.bookmanagement.model.Book;
import com.sda.claudiu.bookmanagement.repository.AuthorRepository;
import com.sda.claudiu.bookmanagement.repository.BookRepository;
import com.sda.claudiu.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.claudiu.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;        // we need here authorRepository because we have to add authorId

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public void createBook(String title, String description, int authorId) throws InvalidParameterException, EntityNotFoundException {
        if (title == null || title.isBlank() || title.length() < 3) {
            throw new InvalidParameterException("Provided value for title: " + title + " is invalid!");
        }
        if (description == null || description.isBlank() || description.length() < 3) {
            throw new InvalidParameterException("Provided value for description: " + description + " is invalid!");
        }
        if (authorId <1) {
            throw new InvalidParameterException("Provided value for author id: " + authorId + " is invalid!");
        }

        Optional<Author> authorOptional = authorRepository.findById(authorId);  // check is author id is valid
        if (authorOptional.isEmpty()) {
            throw new EntityNotFoundException("Author with provided id " + authorId + " was not found!");
        }

        Author author = authorOptional.get();       // get the id found
        Book book = new Book(title, description);   // create the book with title and description
        book.setAuthor(author);                     // connect the book with author to provide id, and this it makes with set
        bookRepository.create(book);                // create the book in the database
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
