package com.quiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResult {

    private String questionId;
    private String questionText;
    private String userAnswer;
    private String correctAnswer;
    private Boolean isCorrect;

}
