package com.sokol.engcards.englishcards.controller;

import com.sokol.engcards.englishcards.entity.Word;
import com.sokol.engcards.englishcards.entity.WordSet;
import com.sokol.engcards.englishcards.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Cards")
public class Controller {
    private final CardService cardService;

    @GetMapping("/words")
    public List<Word> getWords() {
        return cardService.findAllWords();
    }

    @GetMapping("/Sets")
    public List<WordSet> getSets() {
        return cardService.findAllSets();
    }

    @GetMapping("/set")
    public WordSet getSet(@RequestParam String name) {
        return cardService.getSetByName(name);
    }
}
