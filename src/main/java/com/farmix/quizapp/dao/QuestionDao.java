package com.farmix.quizapp.dao;

import com.farmix.quizapp.entity.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findQuestionByCategory(String topic);

    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RAND()", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, Pageable pageable);

}