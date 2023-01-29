package com.sda.claudiu.bookmanagement.controller;

import com.sda.claudiu.bookmanagement.service.AuthorService;
import com.sda.claudiu.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.claudiu.bookmanagement.service.exceptions.InvalidParameterException;

import java.io.IOException;
import java.util.Scanner;

public class AuthorController {
    private final AuthorService authorService;
    private final Scanner scanner = new Scanner(System.in);

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    public void createAuthor() {
        try {
            System.out.println("Please insert author first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Please insert author last name: ");
            String lastName = scanner.nextLine();

            authorService.createAuthor(firstName, lastName);
            System.out.println("Author was created!");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println("Internal server error!");
        }
    }

    public void updateAuthor() {
        try {
            System.out.println("Please insert an author id: ");
            int authorId = Integer.parseInt(scanner.nextLine());
            System.out.println("Please insert author first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Please insert author last name: ");
            String lastName = scanner.nextLine();

            authorService.updateAuthor(authorId, firstName, lastName);
            System.out.println("Author was updated!");
        } catch (EntityNotFoundException | InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Provided author id is not a number!");
        } catch (Exception e) {
            System.out.println("Internal server error!");
        }
    }

    public void deleteAuthor() {
        try {
            System.out.println("Please insert an author id: ");
            int authorId = Integer.parseInt(scanner.nextLine());

            authorService.deleteAuthor(authorId);
            System.out.println("Author was deleted!");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Provided author id is not a number!");
        } catch (Exception e) {
            System.out.println("Internal server error!");
        }
    }

    public void importAuthors() {
        try {
            System.out.println("Authors import started!");
            
            authorService.importAuthors();
            System.out.println("Authors import finished!");
        } catch (IOException e) {
            System.out.println("Internal server error, import failed!");
        }
    }

    public void showAllAuthors() {
        authorService.getAllAuthors().stream().forEach(author ->
                System.out.println("Author with id: " + author.getId()
                        + " firstname: " + author.getFirstName()
                        + " lastname: " + author.getLastName())
        );
    }
}
