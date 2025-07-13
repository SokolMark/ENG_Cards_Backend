package com.sokol.engcards.englishcards.service;

import com.sokol.engcards.englishcards.dto.AnswerDTO;
import com.sokol.engcards.englishcards.entity.Answer;
import com.sokol.engcards.englishcards.entity.Word;
import com.sokol.engcards.englishcards.entity.WordSet;
import com.sokol.engcards.englishcards.repo.AnswerRepo;
import com.sokol.engcards.englishcards.repo.SetRepo;
import com.sokol.engcards.englishcards.repo.WordRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CardService {
    private WordRepo wordRepo;
    private SetRepo setRepo;
    private final AnswerRepo answerRepo;

    public List<Word> findAllWords() {
        return wordRepo.findAll();
    }

    public List<WordSet> findAllSets() {
        return setRepo.findAll();
    }

    public WordSet getSetByName(String name) {
        return setRepo.getSetByName(name);
    }

    public Word getRandomWordInSet(String name) {
        return wordRepo.getRandomWordInSet(name);
    }

    public void saveAnswer(Integer wordId, Integer answerValue) {
        Word word = wordRepo.findById(wordId).orElseThrow();
        Answer answer = new Answer();

        answer.setAnswer(answerValue);
        answer.setWord(word);
        answerRepo.save(answer);
    }

    public List<AnswerDTO> getCorrectAnswer(String name) {
        List<Answer> answers = answerRepo.getCorrectAnswers(name);

        return answers.stream()
                .map(a -> new AnswerDTO(
                        a.getAnswer(),
                        a.getWord().getEngWord(),
                        a.getWord().getUaWord()))
                .toList();
    }

    public List<AnswerDTO> getInCorrectAnswer(String name) {
        List<Answer> answers = answerRepo.getInCorrectAnswers(name);

        return answers.stream()
                .map(a -> new AnswerDTO(
                        a.getAnswer(),
                        a.getWord().getEngWord(),
                        a.getWord().getUaWord()))
                .toList();
    }

    public void addSet(String name) {
        WordSet wordSet = new WordSet();
        wordSet.setName(name);
        setRepo.save(wordSet);
    }

    public void addWord(String name, String engWord, String uaWord) {
        WordSet set = setRepo.getSetByName(name);
        Word word = new Word();

        word.setEngWord(engWord);
        word.setUaWord(uaWord);
        word.setSet(set);

        wordRepo.save(word);
    }

    public void deleteSet(String name) {
        WordSet set = setRepo.getSetByName(name);
        setRepo.delete(set);
    }

    public void deleteWord(Integer id) {
        wordRepo.deleteById(id);
    }
}
