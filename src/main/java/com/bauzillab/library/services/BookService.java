package com.bauzillab.library.services;

import com.bauzillab.library.dtos.BookResponse;
import com.bauzillab.library.dtos.CreateBookRequest;
import com.bauzillab.library.exceptions.BookNotFoundException;

import com.bauzillab.library.models.Book;
import com.bauzillab.library.repositories.BookRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class BookService {
    private final BookRepository repository;
    public BookService(BookRepository repository){
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<BookResponse>findAll(){
        return  repository.findAll().stream()
                .map(BookResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public BookResponse findById(Long id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return BookResponse.from(book);
    }

    public BookResponse create(CreateBookRequest request){
        Book book = new Book(request.title().trim(), request.author().trim(),
                request.isbn() == null ? null : request.isbn().trim());
        return BookResponse.from(repository.save(book));
    }

}
