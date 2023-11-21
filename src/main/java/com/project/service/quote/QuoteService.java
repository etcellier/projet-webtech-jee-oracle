package com.project.service.quote;

import com.project.dto.QuoteDTO;
import com.project.entity.Quote;
import com.project.repository.QuoteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuoteService {

    protected final QuoteMapper quoteMapper;
    protected final QuoteRepository quoteRepository;

    public QuoteService(QuoteMapper quoteMapper, QuoteRepository quoteRepository) {
        this.quoteMapper = quoteMapper;
        this.quoteRepository = quoteRepository;
    }

    public List<Optional<QuoteDTO>> list() {
        List<Optional<QuoteDTO>> quoteDTOList = new ArrayList<>();
        List<Quote> quoteList = quoteRepository.findAll();
        for (Quote quote : quoteList) {
            quoteDTOList.add(Optional.ofNullable(quoteMapper.map(quote)));
        }
        return quoteDTOList;
    }

    public Optional<QuoteDTO> get(Long id) {
        Optional<Quote> quote = quoteRepository.findById(id);
        return quote.map(quoteMapper::map);
    }
}
