package com.sda.claudiu.bookmanagement;

import com.sda.claudiu.bookmanagement.controller.AuthorController;
import com.sda.claudiu.bookmanagement.controller.BookController;
import com.sda.claudiu.bookmanagement.controller.BookReviewController;
import com.sda.claudiu.bookmanagement.menu.UserOption;
import com.sda.claudiu.bookmanagement.repository.AuthorRepositoryImpl;
import com.sda.claudiu.bookmanagement.repository.BookRepositoryImpl;
import com.sda.claudiu.bookmanagement.repository.BookReviewRepositoryImpl;
import com.sda.claudiu.bookmanagement.service.AuthorServiceImpl;
import com.sda.claudiu.bookmanagement.service.BookReviewServiceImpl;
import com.sda.claudiu.bookmanagement.service.BookServiceImpl;
import com.sda.claudiu.bookmanagement.utils.SessionManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SessionManager.getSessionFactory();
        AuthorController authorController = new AuthorController(new AuthorServiceImpl(new AuthorRepositoryImpl()));
        BookController bookController = new BookController(new BookServiceImpl(new BookRepositoryImpl(), new AuthorRepositoryImpl()));
        BookReviewController bookReview = new BookReviewController(new BookReviewServiceImpl(new BookReviewRepositoryImpl(), new BookRepositoryImpl()));
        Scanner scanner = new Scanner(System.in);

        UserOption userOption = UserOption.UNKNOWN;
        do {
            UserOption.printAllOptions();
            System.out.println("Please select an option!");
            try {
                int numericOption = Integer.parseInt(scanner.nextLine());
                userOption = UserOption.findUserOption(numericOption);
            } catch (NumberFormatException e) {
                userOption = UserOption.UNKNOWN;
            }

            switch (userOption) {
                case CREATE_AUTHOR:
                    authorController.createAuthor();
                    break;
                case SHOW_ALL_AUTHORS:
                    authorController.showAllAuthors();
                    break;
                case UPDATE_AUTHOR:
                    authorController.updateAuthor();
                    break;
                case DELETE_AUTHOR:
                    authorController.deleteAuthor();
                    break;
                case CREATE_BOOK:
                    bookController.createBook();
                    break;
                case SHOW_ALL_BOOKS:
                    bookController.showAllBooks();
                    break;
                case UPDATE_BOOK:
                    bookController.updateBook();
                    break;
                case CREATE_BOOK_REVIEW:
                    bookReview.createBookReview();
                    break;
                case SHOW_ALL_REVIEWS:
                    bookReview.viewAllReviews();
                    break;
                case IMPORT_AUTHORS:
                    authorController.importAuthors();
                case EXIT:
                    System.out.println("Good bye!");
                    break;
                case UNKNOWN:
                    System.out.println("Option unknown!");
                    break;
                default:
                    System.out.println("User option " + userOption + " is not implemented!");
                    break;
            }
        } while (userOption != UserOption.EXIT);
        SessionManager.shutDown();
    }
}
