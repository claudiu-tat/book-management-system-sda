package com.sda.claudiu.bookmanagement.controller;

import com.sda.claudiu.bookmanagement.service.BookReviewService;
import com.sda.claudiu.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.claudiu.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.Scanner;

public class BookReviewController {
    private final Scanner scanner = new Scanner(System.in);
    private final BookReviewService bookReviewService;

    public BookReviewController(BookReviewService bookReviewService) {
        this.bookReviewService = bookReviewService;
    }

    public void createBookReview() {
        try {
            System.out.println("Please insert book title: ");
            String bookTitle = scanner.nextLine();
            System.out.println("Please insert a score: ");
            int score = Integer.parseInt(scanner.nextLine());
            System.out.println("Please insert a comment: ");
            String comment = scanner.nextLine();

            bookReviewService.createBookReview(bookTitle, score, comment);
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Please insert a numeric value for score!");
        } catch (Exception e) {
            System.out.println("Internal system error!");
        }
    }
}
