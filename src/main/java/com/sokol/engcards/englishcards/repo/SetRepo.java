package com.sokol.engcards.englishcards.repo;

import com.sokol.engcards.englishcards.entity.WordSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetRepo extends JpaRepository<WordSet, Integer> {
}
