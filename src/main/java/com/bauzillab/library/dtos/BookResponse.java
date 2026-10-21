package com.bauzillab.library.dtos;

import com.bauzillab.library.models.Book;

public record BookResponse(Long id, String title, String author, String isbn) {
    public static BookResponse from(Book book) {
        return new BookResponse(book.getId(), book.getTitle(),
                book.getAuthor(), book.getIsbn());
    }
}
