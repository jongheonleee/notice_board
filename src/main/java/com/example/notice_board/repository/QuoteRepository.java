package com.example.notice_board.repository;

import com.example.notice_board.entity.Quote;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuoteRepository extends CrudRepository<Quote, Long> {

    @Override
    List<Quote> findAll();
}
