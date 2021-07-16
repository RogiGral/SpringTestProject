package com.spring.springtestproject.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent()
    {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("This email is already used");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exist = studentRepository.existsById(studentId);
        if(!exist){
           throw new IllegalStateException(
                   "Student with id" + studentId + "does not exist"
           );
        }
        studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId, String studentName, String studentEmail) {
        Student student = studentRepository
                .findById(studentId).orElseThrow(() -> new IllegalStateException(
                        "Student with id" + studentId + "does not exist"));

        if(studentName != null && studentName.length()>0){
            student.setName(studentName);
        }
        if(studentEmail != null && studentEmail.length()>0){
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(studentEmail);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("This email is already used");
            }
            student.setEmail(studentEmail);
        }
    }
}
