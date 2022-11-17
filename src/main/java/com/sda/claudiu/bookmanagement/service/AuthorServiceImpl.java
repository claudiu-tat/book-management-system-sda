package com.sda.claudiu.bookmanagement.service;

import com.sda.claudiu.bookmanagement.model.Author;
import com.sda.claudiu.bookmanagement.repository.AuthorRepository;
import com.sda.claudiu.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.claudiu.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.List;
import java.util.Optional;

public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void createAuthor(String firstName, String lastName) throws InvalidParameterException {
        if (firstName == null || firstName.isBlank() || firstName.length() < 3) {
            throw new InvalidParameterException("Provided value for first name: " + firstName + " is invalid!");
        }
        if (lastName == null || lastName.isBlank() || lastName.length() < 3) {
            throw new InvalidParameterException("Provided value for last name: " + lastName + " is invalid!");
        }

        authorRepository.create(new Author(firstName, lastName));
    }

    @Override
    public void updateAuthor(int authorId, String fistName, String lastName) throws InvalidParameterException, EntityNotFoundException {
        if (authorId <1) {
            throw new InvalidParameterException("Provided value for author id: " + authorId + " is invalid!");
        }
        if (fistName == null || fistName.isBlank() || fistName.length() < 3) {
            throw new InvalidParameterException("Provided value for first name: " + fistName + " is invalid!");
        }
        if (lastName == null || lastName.isBlank() || lastName.length() < 3) {
            throw new InvalidParameterException("Provided value for last name: " + lastName + " is invalid!");
        }
        Optional<Author> authorOptional = authorRepository.findById(authorId); // search for it in list
        if (authorOptional.isEmpty()) {
            throw new EntityNotFoundException("Author with id: " + authorId + " was not found!");
        }

        Author author = authorOptional.get(); // here we take out after we found it

        author.setFirstName(fistName); // set new values
        author.setLastName(lastName);

        authorRepository.update(author); // update made
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

}
