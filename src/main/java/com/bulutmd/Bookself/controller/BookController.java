package com.bulutmd.Bookself.controller;

import com.bulutmd.Bookself.DTO.BookDto;
import com.bulutmd.Bookself.entity.Book;
import com.bulutmd.Bookself.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
@Autowired
    private BookService bookService;

@GetMapping
    public ResponseEntity<List<Book>> getAll(){
    return bookService.getAllBook();
}
@PostMapping("/createBook")
    public ResponseEntity<Book> createBook(BookDto bookDto){
    return bookService.createBook(bookDto);
}
@GetMapping("/getBook")
public ResponseEntity<Book> getBook(String bookName){
    return bookService.getBook(bookName);
}
@GetMapping("/getWriter")
    public ResponseEntity<List<Book>> getByWriter(String writerName){
    return bookService.getBookByWriter(writerName);
}
@PutMapping("/update")
    public ResponseEntity<Book> update(String book,BookDto bookDto){
    return bookService.update(book,bookDto);
}

}
