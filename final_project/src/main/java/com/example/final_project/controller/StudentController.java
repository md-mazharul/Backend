package com.example.final_project.controller;

import com.example.final_project.entity.Student;
import com.example.final_project.service.StudentService;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
// Importing required classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController

// Class
public class StudentController {

    @Autowired
    private StudentService studentService;
    // Save student information
    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
    // Read student information
    @GetMapping("/students")
    public List<Student> studentList() {
        return studentService.studentList();
    }
    // Find student information
    @GetMapping("/student/{id}")
    public Student getStudentId(@PathVariable("id") Long id) {
        return studentService.getstudentId(id);

    }
    // find by currentYear
    @GetMapping("/currentYear")
    public List<Student> getstudentbycurrrentyear(@RequestParam String id) {
        return studentService.getstudentbycurrrentyear(id);
    }
    // find by major
    @GetMapping({"/major/optional", "/major/optional/{id}"})
    public List<Student> getstudentbymajor(@PathVariable(required = false) String id) {
        return studentService.getstudentbymajor(id);
    }
    //find greater gpa
    @GetMapping(("/gpa/{id}"))
    public List<Student> getgreatergpa(@PathVariable("id") String id) {
        return studentService.getgreatergpa(id);
    }
    //find the students who took more classes
    @GetMapping("/moreclasses/{id}")
    public List<Student> getmoreclassestaken(@PathVariable("id") String id) {
        return studentService.getmoreclassestaken(id);
    }
    //find the students who took fewer classes
    @GetMapping("/lessclasses/{id}")
    public List<Student> getlessclassestaken(@PathVariable("id") String id) {
        return studentService.getlessclassestaken(id);

    }
    //Update student information
    @PutMapping("/student/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") Long studentId) {
        return studentService.updatestudent(student, studentId);
    }
    // Delete student information
    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable("id") Long studentId) {
        studentService.deleteStudentById(studentId);
        return "Deleted Successfully";
    }
}