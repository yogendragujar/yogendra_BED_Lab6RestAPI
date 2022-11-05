package com.greatlearning.studentregistration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.studentregistration.model.Student;
import com.greatlearning.studentregistration.repository.StudentRepository;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getStudents() {
        return new ArrayList<>(this.studentRepository.findAll());
    }

    public Student getStudent(long id) {
        return this.studentRepository.findById(id).get();
    }

    public void saveStudent(Student theStudent) {
        this.studentRepository.save(theStudent);
    }

    public void deleteStudent(long theId) {
        this.studentRepository.deleteById(theId);
    }

}
