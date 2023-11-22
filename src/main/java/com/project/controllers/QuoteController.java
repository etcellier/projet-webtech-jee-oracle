package com.project.controllers;

import com.project.dto.QuoteDTO;
import com.project.service.quote.QuoteService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/quote")
    public void create(@RequestBody QuoteDTO quoteDTO) {
        quoteService.create(quoteDTO);
    }

    @PutMapping("/quote")
    public void update(@RequestBody QuoteDTO quoteDTO) {
        quoteService.update(quoteDTO);
    }

    @DeleteMapping("/quote/{id}")
    public void delete(@PathVariable String id) {
        quoteService.delete(Long.parseLong(id));
    }
}
