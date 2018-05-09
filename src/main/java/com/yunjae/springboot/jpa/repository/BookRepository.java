package com.yunjae.springboot.jpa.repository;

import com.yunjae.springboot.jpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    public Optional<Book> findByIsbn(String isbn);

    List<Book> findByTitleIsLike(@NonNull String title);
}
