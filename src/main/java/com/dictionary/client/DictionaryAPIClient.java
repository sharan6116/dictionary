package com.dictionary.client;

import com.dictionary.model.WordResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DictionaryAPIClient {

    @Value("${dictionary.api.url:https://api.dictionaryapi.dev/api/v2/entries/en}")
    private String apiBaseUrl;

    private final WebClient webClient;

    public Mono<List<WordResult>> searchWord(String word) {
        log.info("Fetching definition for word: {}", word);
        return webClient.get()
                .uri(apiBaseUrl + "/{word}", word)
                .retrieve()
                .bodyToFlux(WordResult.class)
                .collectList()
                .doOnError(error -> log.error("Error fetching word definition: {}", word, error));
    }

}