package com.sokol.engcards.englishcards.service;

import com.sokol.engcards.englishcards.repo.SetRepo;
import com.sokol.engcards.englishcards.repo.WordRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CardService {
    private WordRepo wordRepo;
    private SetRepo setRepo;
}
