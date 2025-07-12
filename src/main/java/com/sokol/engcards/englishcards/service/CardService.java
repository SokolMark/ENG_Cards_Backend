package com.sokol.engcards.englishcards.service;

import com.sokol.engcards.englishcards.entity.Word;
import com.sokol.engcards.englishcards.entity.WordSet;
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

/*    public List<Word> findAllWords() {
      return wordRepo.findAll();
*/

    public List<WordSet> findAllSets() {
        return setRepo.findAll();
    }


}
