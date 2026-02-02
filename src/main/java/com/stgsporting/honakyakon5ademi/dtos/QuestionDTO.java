package com.stgsporting.honakyakon5ademi.dtos;

import com.stgsporting.honakyakon5ademi.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuestionDTO {
    private String text;
    private Type type;
}
