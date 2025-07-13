package com.sokol.engcards.englishcards.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id")
    private Long wordId;
    @Column(name = "eng_word")
    private String engWord;
    @Column(name = "ua_word")
    private String uaWord;

    @ManyToOne
    @JoinColumn(name = "set_id")
    @JsonIgnore
    private WordSet set;

    @OneToOne(mappedBy = "word", cascade = CascadeType.ALL, orphanRemoval = true)
    private Answer answer;
}
