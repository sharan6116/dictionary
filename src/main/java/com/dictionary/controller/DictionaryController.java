package com.dictionary.controller;

import com.dictionary.model.WordResult;
import com.dictionary.service.DictionaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/dictionary")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @GetMapping("/search/{word}")
    public Mono<ResponseEntity<List<WordResult>>> searchWord(@PathVariable String word) {
        log.info("Received request to search for word: {}", word);
        return dictionaryService.getWordDefinition(word)
                .map(ResponseEntity::ok)
                .onErrorReturn(ResponseEntity.notFound().build());
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Dictionary API is running!");
    }

}