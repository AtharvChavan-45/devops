package com.devops.studentmanagement;

import com.devops.studentmanagement.entity.Student;
import com.devops.studentmanagement.exception.ResourceNotFoundException;
import com.devops.studentmanagement.repository.StudentRepository;
import com.devops.studentmanagement.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTests {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    private Student student1;
    private Student student2;

    @BeforeEach
    void setUp() {
        student1 = new Student(1L, "Atharv", "Patil", "atharv@example.com", "Computer Science", 6);
        student2 = new Student(2L, "Rahul", "Sharma", "rahul@example.com", "Information Technology", 6);
    }

    @Test
    @DisplayName("Test 1: Save student returns saved student object")
    void testSaveStudent() {
        when(studentRepository.save(any(Student.class))).thenReturn(student1);

        Student saved = studentService.saveStudent(student1);

        assertThat(saved).isNotNull();
        assertThat(saved.getFirstName()).isEqualTo("Atharv");
        verify(studentRepository, times(1)).save(student1);
    }

    @Test
    @DisplayName("Test 2: Get all students returns list of students")
    void testGetAllStudents() {
        when(studentRepository.findAll()).thenReturn(Arrays.asList(student1, student2));

        List<Student> students = studentService.getAllStudents();

        assertThat(students).hasSize(2);
        assertThat(students.get(0).getEmail()).isEqualTo("atharv@example.com");
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Test 3: Get student by ID returns student when ID exists")
    void testGetStudentByIdSuccess() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student1));

        Student found = studentService.getStudentById(1L);

        assertThat(found).isNotNull();
        assertThat(found.getId()).isEqualTo(1L);
        assertThat(found.getDepartment()).isEqualTo("Computer Science");
    }

    @Test
    @DisplayName("Test 4: Get student by ID throws exception when ID does not exist")
    void testGetStudentByIdNotFound() {
        when(studentRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> studentService.getStudentById(99L));
    }

    @Test
    @DisplayName("Test 5: Update student modifies details and saves")
    void testUpdateStudent() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student1));
        when(studentRepository.save(any(Student.class))).thenReturn(student1);

        Student updatedDetails = new Student("Atharv", "Patil", "atharv.updated@example.com", "AI & DS", 7);
        Student result = studentService.updateStudent(1L, updatedDetails);

        assertThat(result.getEmail()).isEqualTo("atharv.updated@example.com");
        assertThat(result.getDepartment()).isEqualTo("AI & DS");
        assertThat(result.getSemester()).isEqualTo(7);
        verify(studentRepository, times(1)).save(any(Student.class));
    }

    @Test
    @DisplayName("Test 6: Delete student removes student when ID exists")
    void testDeleteStudent() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student1));
        doNothing().when(studentRepository).delete(student1);

        studentService.deleteStudent(1L);

        verify(studentRepository, times(1)).delete(student1);
    }
}
