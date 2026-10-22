package com.bauzillab.library.controllers;

import com.bauzillab.library.dtos.BookResponse;
import com.bauzillab.library.dtos.CreateBookRequest;
import com.bauzillab.library.services.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    public final BookService service;
    public BookController(BookService service){
        this.service = service;
    }
    @GetMapping
    public List<BookResponse> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public BookResponse findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse create(@Valid @RequestBody CreateBookRequest request){
        return  service.create(request);
    }

}
