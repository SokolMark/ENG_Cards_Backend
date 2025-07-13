package com.sokol.engcards.englishcards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnswerDTO {
    private Integer answer;
    private String engWord;
    private String uaWord;
}
