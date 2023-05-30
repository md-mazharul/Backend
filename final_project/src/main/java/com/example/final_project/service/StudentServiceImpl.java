package com.example.final_project.service;


// Importing required classes

import java.util.*;

import com.example.final_project.entity.Student;
import com.example.final_project.repositoty.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    // Save student information
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    // Read student information
    @Override
    public List<Student> studentList() {
        return (List<Student>) studentRepository.findAll();
    }
    // Find student information
    @Override
    public Student getstudentId(Long studentId){

        List<Student> students = studentList();

        for (Student student: students) {
            if (student.getStudentId() == studentId){
                return student;
            }
        }
        return null;
    }
    //find student current year
    @Override
    public List<Student> getstudentbycurrrentyear(String id){

        List<Student> students = studentList();
        List<Student> tempStudents = new ArrayList<>();

        for (Student student: students) {
            if (student.getCurrentYear().equals(id)){
                tempStudents.add(student);
            }
        }
        return tempStudents;
    }
    //find student major
    @Override
    public List<Student> getstudentbymajor(String id){

        List<Student> students = studentList();
        List<Student> tempStudents = new ArrayList<>();

        for (Student student: students) {
            if (student.getMajor()==id){
                tempStudents.add(student);
            }
            tempStudents.add(student);
        }
        return tempStudents;
    }
    //find the student who get greater gpa
    @Override
    public List<Student> getgreatergpa(String id){

        List<Student> students = studentList();
        List<Student> tempStudents = new ArrayList<>();

        double target_gpa = Double.parseDouble(id);

        for (Student student: students) {
            double tempgpa = Double.parseDouble(student.getStudentGpa());

            if(tempgpa >= target_gpa){
                tempStudents.add(student);
            }
        }
        return tempStudents;
    }
    // find the student who took more than classes
    @Override
    public List<Student> getmoreclassestaken(String id){

        List<Student> students = studentList();
        List<Student> tempStudents = new ArrayList<>();

        double target_classes_taken = Double.parseDouble(id);

        for (Student student: students) {
            double temp_classes_taken = Double.parseDouble(student.getClassesTaken());

            if(temp_classes_taken >= target_classes_taken){
                tempStudents.add(student);
            }
        }
        return tempStudents;
    }
    // find the student who took less than classes
    @Override
    public List<Student> getlessclassestaken(String id){

        List<Student> students = studentList();
        List<Student> tempStudents = new ArrayList<>();

        double target_classes_taken = Double.parseDouble(id);

        for (Student student: students) {
            double temp_classes_taken = Double.parseDouble(student.getClassesTaken());

            if(temp_classes_taken < target_classes_taken){
                tempStudents.add(student);
            }
        }
        return tempStudents;
    }

    // Update student information
    @Override
    public Student updatestudent(Student student,
                                 Long studentId) {

        Student depDB = studentRepository.findById(studentId).get();

        if (Objects.nonNull(student.getStudentFullName())
                && !"".equalsIgnoreCase(
                student.getStudentFullName())) {
            depDB.setStudentFullName(
                    student.getStudentFullName());
        }

        if (Objects.nonNull(student.getCurrentYear()) && !"".equalsIgnoreCase(student.getCurrentYear())) {
            depDB.setCurrentYear(student.getCurrentYear());
        }

        if (Objects.nonNull(student.getMajor())
                && !"".equalsIgnoreCase(
                student.getMajor())) {
            depDB.setMajor(
                    student.getMajor());
        }
        if (Objects.nonNull(student.getStudentGpa())
                && !"".equalsIgnoreCase(
                (student.getStudentGpa()))) {
            depDB.setStudentGpa(
                    student.getStudentGpa());
        }
        if (Objects.nonNull(student.getClassesTaken())
                && !"".equalsIgnoreCase(
                (student.getClassesTaken()))) {
            depDB.setClassesTaken(
                    student.getClassesTaken());
        }
        if (Objects.nonNull(student.getUserName())
                && !"".equalsIgnoreCase(
                (student.getUserName()))) {
            depDB.setUserName(
                    student.getUserName());
        }
        if (Objects.nonNull(student.getPassword())
                && !"".equalsIgnoreCase(
                (student.getPassword()))) {
            depDB.setPassword(
                    student.getPassword());
        }
        return studentRepository.save(depDB);
    }

    // Delete student information
    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }





}
