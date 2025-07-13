package com.sokol.engcards.englishcards.repo;

import com.sokol.engcards.englishcards.entity.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepo extends CrudRepository<Answer, Integer> {
    @Query(value = "SELECT a.* " +
                   "FROM answer a " +
                   "JOIN word w ON a.word_id = w.word_id " +
                   "JOIN word_set s ON w.set_id = s.set_id " +
                   "WHERE s.name = ? AND a.answer = 1",
            nativeQuery = true)
    List<Answer> getCorrectAnswers(String setName);

    @Query(value = "SELECT a.* " +
                   "FROM answer a " +
                   "JOIN word w ON a.word_id = w.word_id " +
                   "JOIN word_set s ON w.set_id = s.set_id " +
                   "WHERE s.name = ? AND a.answer = 0",
            nativeQuery = true)
    List<Answer> getInCorrectAnswers(String setName);
}
