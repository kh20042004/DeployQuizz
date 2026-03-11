package com.quiz.config;

import com.quiz.model.Question;
import com.quiz.service.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void run(String... args) throws Exception {
        // Only add questions if database is empty
        if (questionRepository.count() == 0) {
            addSampleQuestions();
        }
    }

    private void addSampleQuestions() {
        // Question 1 - Java
        questionRepository.save(new Question(
                null,
                "Tính năng nào được giới thiệu trong Java 8 để hỗ trợ các hoạt động theo phong cách hàm trên các luồng phần tử?",
                "A. Các chú thích (Annotations)",
                "B. Generics",
                "C. Biểu thức Lambda",
                "D. Mô-đun (Modules)",
                "C",
                "Java"
        ));

        // Question 2 - HTTP
        questionRepository.save(new Question(
                null,
                "Mã trạng thái HTTP nào thường chỉ ra rằng tài nguyên được yêu cầu không được tìm thấy trên máy chủ?",
                "A. 200 OK",
                "B. 403 Forbidden",
                "C. 404 Not Found",
                "D. 500 Internal Server Error",
                "C",
                "HTTP"
        ));

        // Question 3 - Spring Boot
        questionRepository.save(new Question(
                null,
                "Chú thích nào được sử dụng để đánh dấu một lớp là controller Spring MVC?",
                "A. @Service",
                "B. @Component",
                "C. @Repository",
                "D. @Controller",
                "D",
                "Spring Boot"
        ));

        // Question 4 - Database
        questionRepository.save(new Question(
                null,
                "Trong MongoDB, tương đương với bảng cơ sở dữ liệu quan hệ là gì?",
                "A. Document",
                "B. Collection",
                "C. Schema",
                "D. Query",
                "B",
                "Database"
        ));

        // Question 5 - Docker
        questionRepository.save(new Question(
                null,
                "Lệnh nào được sử dụng để xây dựng một Docker image từ Dockerfile?",
                "A. docker run",
                "B. docker push",
                "C. docker build",
                "D. docker create",
                "C",
                "Docker"
        ));

        System.out.println("✅ Các câu hỏi mẫu đã được thêm vào MongoDB!");
    }

}
