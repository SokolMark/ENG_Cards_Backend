package com.sokol.engcards.englishcards.repo;

import com.sokol.engcards.englishcards.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepo extends JpaRepository<Word, Integer> {
    @Query(value = "SELECT w.* " +
                   "FROM word w" +
                   "JOIN word_set s ON w.set_id = s.set_id " +
                   "WHERE s.name = ? " +
                   "ORDER BY RANDOM() LIMIT 1"
            , nativeQuery = true)
    Word getRandomWordInSet(String name);
}
