package com.bulutmd.Bookself.repository;

import com.bulutmd.Bookself.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
Book getBookByBookName(String bookName);
List<Book> getAllByBookWriter(String bookWriter);
}