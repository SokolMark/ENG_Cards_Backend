package com.sokol.engcards.englishcards.controller;

import com.sokol.engcards.englishcards.dto.AnswerDTO;
import com.sokol.engcards.englishcards.entity.Word;
import com.sokol.engcards.englishcards.entity.WordSet;
import com.sokol.engcards.englishcards.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cards")
public class Controller {
    private final CardService cardService;

    @GetMapping("/words")
    public List<Word> getWords() {
        return cardService.findAllWords();
    }

    @GetMapping("/sets")
    public List<WordSet> getSets() {
        return cardService.findAllSets();
    }

    @GetMapping("/set")
    public WordSet getSet(@RequestParam String name) {
        return cardService.getSetByName(name);
    }

    @GetMapping("/word")
    public Word getWord(@RequestParam String name) {
        return cardService.getRandomWordInSet(name);
    }

    @PostMapping("/saveAnswer")
    public void saveAnswer(@RequestParam Integer wordId, @RequestParam Integer answer) {
        cardService.saveAnswer(wordId, answer);
    }

    @GetMapping("/correctAnswers")
    public List<AnswerDTO> getAnswer(@RequestParam String name) {
        return cardService.getCorrectAnswer(name);
    }

    @GetMapping("/wrongAnswers")
    public List<AnswerDTO> getWrongAnswers(@RequestParam String name) {
        return cardService.getInCorrectAnswer(name);
    }

    @PostMapping("/addSet")
    public void addSet(@RequestParam String name) {
        cardService.addSet(name);
    }

    @PostMapping("/addWord")
    public void addWord(@RequestParam String name,
                        @RequestParam String engWord,
                        @RequestParam String uaWord) {
        cardService.addWord(name, engWord, uaWord);
    }

    @DeleteMapping("/deleteSet")
    public void deleteSet(@RequestParam String name) {
        cardService.deleteSet(name);
    }

    @DeleteMapping("/deleteWord")
    public void deleteWord(@RequestParam Integer id) {
        cardService.deleteWord(id);
    }

}
