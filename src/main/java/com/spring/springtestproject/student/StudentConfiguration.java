package com.spring.springtestproject.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student Marian = new Student(
                    "Marian",
                    "lol.a@gmail.pl",
                    LocalDate.of(1999, Month.JUNE,3)
            );
            Student Adam = new Student(
                    "Adam",
                    "adam.b@gmail.pl",
                    LocalDate.of(1969, Month.APRIL,4)
            );
            repository.saveAll(List.of(Marian,Adam));
        };
    }
}
