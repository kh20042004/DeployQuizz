package com.quiz.service;

import com.quiz.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizAttemptRepository quizAttemptRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(String id) {
        return questionRepository.findById(id).orElse(null);
    }

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public QuizResponse evaluateQuiz(List<QuizSubmission> submissions) {
        int totalQuestions = submissions.size();
        int correctAnswers = 0;
        List<QuestionResult> results = new ArrayList<>();

        for (QuizSubmission submission : submissions) {
            Question question = getQuestionById(submission.getQuestionId());
            
            if (question != null) {
                boolean isCorrect = question.getCorrectAnswer()
                        .equalsIgnoreCase(submission.getUserAnswer());
                
                if (isCorrect) {
                    correctAnswers++;
                }

                QuestionResult result = new QuestionResult(
                        question.getId(),
                        question.getQuestionText(),
                        submission.getUserAnswer(),
                        question.getCorrectAnswer(),
                        isCorrect
                );
                
                results.add(result);
            }
        }

        int score = (correctAnswers * 100) / (totalQuestions > 0 ? totalQuestions : 1);

        // Save attempt to database
        QuizAttempt attempt = new QuizAttempt(totalQuestions, correctAnswers, score);
        quizAttemptRepository.save(attempt);

        return new QuizResponse(
                totalQuestions,
                correctAnswers,
                score,
                results
        );
    }

    public QuizStats getQuizStats() {
        long totalParticipants = quizAttemptRepository.count();
        long totalQuestions = questionRepository.count();
        
        // Calculate average score
        List<QuizAttempt> attempts = quizAttemptRepository.findAll();
        double averageScore = attempts.stream()
                .mapToInt(QuizAttempt::getScore)
                .average()
                .orElse(0.0);

        return new QuizStats(totalParticipants, totalQuestions, averageScore);
    }

}
