package com.pallysystems.datajpa.student;

import com.pallysystems.datajpa.student.models.Classroom;
import com.pallysystems.datajpa.student.models.Student;
import com.pallysystems.datajpa.student.repository.ClassroomRepository;
import com.pallysystems.datajpa.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not found requested student ID.");
        }

        return optionalStudent.get();
    }

    public List<Classroom> getClassrooms() {
        return classroomRepository.findAll();
    }
}
