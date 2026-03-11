package com.quiz.service;

import com.quiz.model.QuizAttempt;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizAttemptRepository extends MongoRepository<QuizAttempt, String> {

    // MongoDB will automatically count all documents
    long count();

}
