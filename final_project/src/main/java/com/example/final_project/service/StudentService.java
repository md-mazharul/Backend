package com.example.final_project.service;

import com.example.final_project.entity.Student;
// Importing required classes
import java.util.List;
import java.util.Optional;


// Class
public interface StudentService {

    // Save student information
    Student saveStudent(Student student);

    // Read student information
    List<Student> studentList();

    // Find student information
    Student getstudentId(Long studentId);

    List<Student> getgreatergpa(String id);

    List<Student> getmoreclassestaken(String id);

    List<Student> getlessclassestaken(String id);

    //Student findid(Long studentId);

    // Update student information
    Student updatestudent(Student student, Long studentId);

    // Delete student information
    void deleteStudentById(Long studentId);

    List<Student> getstudentbycurrrentyear(String id);

    List<Student> getstudentbymajor(String id);


}
