package com.quiz.controller;

import com.quiz.model.Question;
import com.quiz.model.QuizResponse;
import com.quiz.model.QuizSubmission;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "*")
public class QuizController {

    @Autowired
    private QuizService quizService;

    /**
     * Get all questions
     */
    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = quizService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    /**
     * Get question by ID
     */
    @GetMapping("/questions/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable String id) {
        Question question = quizService.getQuestionById(id);
        if (question != null) {
            return ResponseEntity.ok(question);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Get questions by category
     */
    @GetMapping("/questions/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        List<Question> questions = quizService.getQuestionsByCategory(category);
        return ResponseEntity.ok(questions);
    }

    /**
     * Submit quiz and get results
     */
    @PostMapping("/submit")
    public ResponseEntity<QuizResponse> submitQuiz(@RequestBody List<QuizSubmission> submissions) {
        QuizResponse response = quizService.evaluateQuiz(submissions);
        return ResponseEntity.ok(response);
    }

    /**
     * Create a new question
     */
    @PostMapping("/questions")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        Question savedQuestion = quizService.saveQuestion(question);
        return ResponseEntity.ok(savedQuestion);
    }

    /**
     * Health check endpoint
     */
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Quiz API is running!");
    }

    /**
     * Get quiz statistics
     */
    @GetMapping("/stats")
    public ResponseEntity<com.quiz.model.QuizStats> getStats() {
        com.quiz.model.QuizStats stats = quizService.getQuizStats();
        return ResponseEntity.ok(stats);
    }

}
