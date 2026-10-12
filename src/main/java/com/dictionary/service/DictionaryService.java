package com.dictionary.service;

import com.dictionary.client.DictionaryAPIClient;
import com.dictionary.model.WordResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DictionaryService {

    private final DictionaryAPIClient dictionaryAPIClient;

    public Mono<List<WordResult>> getWordDefinition(String word) {
        log.info("Getting definition for word: {}", word);
        return dictionaryAPIClient.searchWord(word);
    }

}