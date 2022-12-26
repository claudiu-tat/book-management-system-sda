package com.sda.claudiu.bookmanagement.menu;

public enum UserOption {
    CREATE_AUTHOR(1, "Create author"),
    SHOW_ALL_AUTHORS(2, "Display all authors"),
    UPDATE_AUTHOR(3,"Update author"),
    DELETE_AUTHOR(4, "Delete author"),
    CREATE_BOOK(5, "Create book"),
    SHOW_ALL_BOOKS(6,"Display all books"),
    UPDATE_BOOK(7, "Update book"),
    DELETE_BOOK(8, "Delete book"),
    CREATE_BOOK_REVIEW(9, "Create book review"),
    SHOW_ALL_REVIEWS(10, "Display all reviews"),
    SHOW_ALL_REVIEWS_OF_A_GIVEN_BOOK(11, "Display all reviews of a given book"),
    IMPORT_AUTHORS(12, "Import csv file with authors"),
    EXIT(99, "Exit"),
    UNKNOWN(100, "Unknown option");

    private int numericOption;
    private String displayValue;

    UserOption(int numericOption, String displayValue) {
        this.numericOption = numericOption;
        this.displayValue = displayValue;
    }

    public int getNumericOption() {
        return numericOption;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public static void printAllOptions() {
        for (UserOption value : values()) {
            if (value != UNKNOWN) {
                System.out.println(value.getNumericOption() + " - " + value.getDisplayValue());
            }
        }
    }

    public static UserOption findUserOption(int numericValue) {
        for (UserOption value : values()) {
            if (value.getNumericOption() == numericValue) {
                return value;
            }
        }
        return UNKNOWN;
    }
}
