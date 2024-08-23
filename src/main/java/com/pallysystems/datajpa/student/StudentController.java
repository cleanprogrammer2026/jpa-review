package com.pallysystems.datajpa.student;

import com.pallysystems.datajpa.student.models.Classroom;
import com.pallysystems.datajpa.student.models.Student;
import com.pallysystems.datajpa.student.models.requests.StudentDto;
import com.pallysystems.datajpa.utils.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<?> registerStudent(
            @Valid @RequestBody StudentDto studentDto, BindingResult result) {
        if( result.hasErrors()) {
            ApiResponse<?> response =
                    new ApiResponse<>( false,"Field validation error(s)",
                            result.getAllErrors());
            return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(new ApiResponse<>(true, "Record registered successfully",
                studentDto), HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<ApiResponse<List<Student>>> getStudents() {
        ApiResponse<List<Student>> response =
                new ApiResponse<List<Student>>( true,"Student records returned successfully.",
                studentService.getStudents());

        return new ResponseEntity<ApiResponse<List<Student>>>(response, HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable("id") Long id) {
        ApiResponse<Student> response = new ApiResponse<>(true,
                "", studentService.getStudentById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/classrooms")
    public ResponseEntity<List<Classroom>> getClassrooms() {
        return new ResponseEntity<>(studentService.getClassrooms(), HttpStatus.OK);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiResponse<String>> handleNotFound(ResponseStatusException ex) {
        ApiResponse<String> response = new ApiResponse<>(false,
                null, ex.getReason());
        return new ResponseEntity<>(response, ex.getStatusCode());
    }
}
