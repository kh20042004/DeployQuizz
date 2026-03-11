package com.quiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizResponse {

    private int totalQuestions;
    private int correctAnswers;
    private int score;
    private List<QuestionResult> results;

}
