package com.pallysystems.datajpa.runner;

import com.pallysystems.datajpa.student.models.Classroom;
import com.pallysystems.datajpa.student.models.Student;
import com.pallysystems.datajpa.student.repository.ClassroomRepository;
import com.pallysystems.datajpa.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RecordFakerRunner implements CommandLineRunner {

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) {
        System.out.println("Running no runner");
//        // Create classroom
//        Classroom classroom1 = new Classroom("Class A");
//
//        classroomRepository.save(classroom1);
//
//        // Class A
//        Student studentA1 = new Student("Ebuka",
//                "Chizota", "ebukavictor@gmail.com",
//                30, classroom1);
//        Student studentA2 = new Student("Victor",
//                "Chizota", "chizotavictor@gmail.com",
//                30, classroom1);
//
//        studentRepository.save(studentA1);
//        studentRepository.save(studentA2);
//
//        System.out.println("Called runner");
    }

}
