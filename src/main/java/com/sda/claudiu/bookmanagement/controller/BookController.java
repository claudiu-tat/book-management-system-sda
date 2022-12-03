package com.sda.claudiu.bookmanagement.controller;

import com.sda.claudiu.bookmanagement.service.BookService;
import com.sda.claudiu.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.claudiu.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.Scanner;

public class BookController {
    private final Scanner scanner = new Scanner(System.in);
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void createBook() {
        try {
            System.out.println("Please insert a title: ");
            String title = scanner.nextLine();
            System.out.println("Please insert a description: ");
            String description = scanner.nextLine();
            System.out.println("Please insert an author id: ");
            int authorId = Integer.parseInt(scanner.nextLine());

            bookService.createBook(title, description, authorId);
            System.out.println("Book was created!");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Please insert a numeric value for author id!");
        } catch (Exception e) {
            System.out.println("Internal system error!");
        }
    }

    public void updateBook() {
        try {
            System.out.println("Please insert a book id: ");
            int bookId = Integer.parseInt(scanner.nextLine());
            System.out.println("Please insert new title of the book: ");
            String bookTitle = scanner.nextLine();
            System.out.println("Please insert new description of the book: ");
            String description = scanner.nextLine();
            System.out.println("Please insert an author id: ");
            int authorId = Integer.parseInt(scanner.nextLine());

            bookService.updateBook(bookId, bookTitle, description, authorId);
            System.out.println("Book was updated!");

        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Please insert a numeric value for author id!");
        } catch (Exception e) {
            System.out.println("Internal system error!");
        }
    }

    public void deleteBook() {
        try {
            System.out.println("Please insert a book id: ");
            int bookId = Integer.parseInt(scanner.nextLine());
            bookService.deleteBook(bookId);
            System.out.println("Book was deleted!");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Please insert a numeric value for author id!");
        } catch (Exception e) {
            System.out.println("Internal system error!");
        }
    }

    public void showAllBooks() {
        bookService.getAllBooks().stream()
                .forEach(book ->
                        System.out.println(
                                "Book id: " + book.getId()
                                        + " title " + book.getTitle()
                                        + " author " + book.getAuthor().getFirstName()
                                        + " " + book.getAuthor().getLastName()
                        )
                );
    }
}
