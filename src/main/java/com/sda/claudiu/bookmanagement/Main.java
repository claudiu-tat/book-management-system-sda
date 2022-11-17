package com.sda.claudiu.bookmanagement;

import com.sda.claudiu.bookmanagement.controller.AuthorController;
import com.sda.claudiu.bookmanagement.menu.UserOption;
import com.sda.claudiu.bookmanagement.repository.AuthorRepositoryImpl;
import com.sda.claudiu.bookmanagement.service.AuthorServiceImpl;
import com.sda.claudiu.bookmanagement.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory();
        AuthorController authorController = new AuthorController(new AuthorServiceImpl(new AuthorRepositoryImpl()));
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
