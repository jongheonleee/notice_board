package com.example.notice_board.controller;

import com.example.notice_board.entity.Quote;
import com.example.notice_board.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @Autowired
    private QuoteService quoteService;

    @GetMapping("/")
    public String home(Model model) {
        Quote quote = quoteService.getRandom();
        model.addAttribute("quote", quote);
        return "home";
    }
}
