package com.devops.studentmanagement.service;

import com.devops.studentmanagement.entity.Student;

import java.util.List;

public interface StudentService {

    // 1. Add / Create a new student
    Student saveStudent(Student student);

    // 2. View all students
    List<Student> getAllStudents();

    // 3. Search student by ID
    Student getStudentById(Long id);

    // 4. Update student details
    Student updateStudent(Long id, Student studentDetails);

    // 5. Delete a student
    void deleteStudent(Long id);
}
