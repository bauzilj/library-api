package com.bauzillab.library.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Livro com ID " + id + " não foi encontrado");
    }
}
