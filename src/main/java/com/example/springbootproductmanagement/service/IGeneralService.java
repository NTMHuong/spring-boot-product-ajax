package com.example.springbootproductmanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Page<T> findAll(Pageable pageable);

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);

}
