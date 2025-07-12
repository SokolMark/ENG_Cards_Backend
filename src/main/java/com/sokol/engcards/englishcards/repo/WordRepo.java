package com.sokol.engcards.englishcards.repo;

import com.sokol.engcards.englishcards.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepo extends JpaRepository<Word, Integer> { }
