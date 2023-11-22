package com.project.controllers;

import com.project.dto.QuoteDTO;
import com.project.service.quote.QuoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class QuoteController {

    protected final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/quotes")
    public List<Optional<QuoteDTO>> list() {
        return quoteService.list();
    }

    @GetMapping("/quote/{id}")
    public Optional<QuoteDTO> get(@PathVariable String id) {
        return quoteService.get(Long.parseLong(id));
    }

}
