package com.stgsporting.honakyakon5ademi.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ViewInitializer {

    private final JdbcTemplate jdbcTemplate;

    public ViewInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initializeViews() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS progress");
        
        jdbcTemplate.execute("""
            CREATE OR REPLACE VIEW progress AS
            SELECT 
                k.id AS khedma_id,
                COUNT(r.id) AS total_responses,
                SUM(CASE WHEN DATE(q.date) = CURDATE() THEN 1 ELSE 0 END) AS today_responses
            FROM khedmas k
            LEFT JOIN users u ON u.khedma_id = k.id
            LEFT JOIN responses r ON r.user_id = u.id
            LEFT JOIN quizzes q ON r.quiz_id = q.id
            GROUP BY k.id
            """);
    }
}
