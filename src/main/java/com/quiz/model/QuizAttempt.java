package com.quiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "quiz_attempts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizAttempt {

    @Id
    private String id;

    private int totalQuestions;

    private int correctAnswers;

    private int score;

    private LocalDateTime completedAt;

    private String ipAddress; // Optional: track unique participants

    public QuizAttempt(int totalQuestions, int correctAnswers, int score) {
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.score = score;
        this.completedAt = LocalDateTime.now();
    }

}
