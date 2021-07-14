package com.spring.springtestproject.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "app/v1/student")
public class StudentController {
    @GetMapping
    public List<Student> hello()
    {
        return List.of(
                new Student(
                        1L,
                        "Marian",
                        "lol.a@gmail.pl",
                        LocalDate.of(1999, Month.JUNE,3),
                        22
                )
        );
    }
}
