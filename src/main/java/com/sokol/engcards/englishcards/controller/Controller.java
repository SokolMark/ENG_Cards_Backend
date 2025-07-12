package com.sokol.engcards.englishcards.controller;

import com.sokol.engcards.englishcards.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/Cards")
public class Controller {
    private final CardService cardService;

}
