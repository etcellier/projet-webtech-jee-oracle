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

    // Méthode list() qui liste les quotes
    @GetMapping("/quotes")
    public List<Optional<QuoteDTO>> list() {
        return quoteService.list();
    }

    // Méthode get() qui récupère une quote en fonction de son id
    @GetMapping("/quote/{id}")
    public Optional<QuoteDTO> get(@PathVariable String id) {
        return quoteService.get(Long.parseLong(id));
    }

    // Méthode create() qui crée une quote grâce au body de la requête
    @PostMapping("/quote")
    public void create(@RequestBody QuoteDTO quoteDTO) {
        quoteService.create(quoteDTO);
    }

    // Méthode update() qui met à jour une quote grâce au body de la requête
    @PutMapping("/quote")
    public void update(@RequestBody QuoteDTO quoteDTO) {
        quoteService.update(quoteDTO);
    }

    // Méthode delete() qui supprime une quote en fonction de son id
    @DeleteMapping("/quote/{id}")
    public void delete(@PathVariable String id) {
        quoteService.delete(Long.parseLong(id));
    }
}
