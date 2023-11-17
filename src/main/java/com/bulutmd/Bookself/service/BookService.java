package com.bulutmd.Bookself.service;

import com.bulutmd.Bookself.DTO.BookDto;
import com.bulutmd.Bookself.entity.Book;
import com.bulutmd.Bookself.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<Book> createBook(BookDto bookDto) {
        Book book = new Book();
        book.setBookName(bookDto.getBookName());
        book.setBookWriter(bookDto.getBookWriter());
        book.setBookYear(bookDto.getBookYear());

        return ResponseEntity.ok(bookRepository.save(book));

    }
public ResponseEntity<List<Book>> getAllBook(){
        return ResponseEntity.ok(bookRepository.findAll());
}
public ResponseEntity<Book> getBook(String name) {

        return ResponseEntity.ok(bookRepository.getBookByBookName(name));

    }

public ResponseEntity<List<Book>> getBookByWriter(String writerName) {
        return ResponseEntity.ok(bookRepository.getAllByBookWriter(writerName));
    }

 public ResponseEntity<Book> update(String bookName, BookDto bookDto) {
        Book book = bookRepository.getBookByBookName(bookName);
        if (book == null) {
            return ResponseEntity.badRequest().build();
        }
        book.setBookYear(bookDto.getBookYear());
        book.setBookWriter(bookDto.getBookWriter());
        book.setBookName(bookDto.getBookName());
        bookRepository.save(book);
        return ResponseEntity.ok(book);
    }


}
