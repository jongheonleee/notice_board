package com.example.notice_board.service;

import com.example.notice_board.entity.Quote;
import com.example.notice_board.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    private Random random = new Random();


    public Quote getRandom() {
        List<Quote> quotes = quoteRepository.findAll();
        int idx = random.nextInt(quotes.size());
        return quotes.get(idx);
    }
}
