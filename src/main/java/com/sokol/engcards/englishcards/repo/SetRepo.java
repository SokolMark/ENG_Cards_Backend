package com.sokol.engcards.englishcards.repo;

import com.sokol.engcards.englishcards.entity.WordSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SetRepo extends JpaRepository<WordSet, Integer> {
    @Query(value = "SELECT * FROM word_set WHERE name = ?", nativeQuery = true)
    WordSet getSetByName(String name);
}
