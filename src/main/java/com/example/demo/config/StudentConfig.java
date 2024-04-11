package com.example.demo.config;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return  args -> {
               Student benny = new Student(
                            1L,
                            "Benny",
                            LocalDate.of(1997, Month.JANUARY, 8),
                            "benny@gmail.com"

            );
            Student danny = new Student(
                    "Danny",
                    LocalDate.of(1999, Month.JANUARY, 6),
                    "danny@gmail.com"


            );
            repository.saveAll(
                    List.of(benny, danny)
            );


        };
    }
}
