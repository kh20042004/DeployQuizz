package com.quiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizStats {

    private long totalParticipants;
    
    private long totalQuestions;
    
    private double averageScore;

}
