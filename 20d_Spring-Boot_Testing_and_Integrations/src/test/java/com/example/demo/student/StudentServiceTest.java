package com.example.demo.student;

import com.example.demo.student.exception.BadRequestException;
import com.example.demo.student.exception.StudentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock private StudentRepository studentRepository;
    private StudentService underTest;

    @BeforeEach
    void setUp() {
        underTest = new StudentService(studentRepository);
    }


    @Test
    void canGetAllStudents() {
        // when
        underTest.getAllStudents();
        // then
        verify(studentRepository).findAll();
    }

//    //borrar !!!!!!!
//    public void addStudent(Student student) {
//        Boolean existsEmail = studentRepository
//                .selectExistsEmail(student.getEmail());
//        if (existsEmail) {
//            throw new BadRequestException(
//                    "Email " + student.getEmail() + " taken");
//        }
//
//        studentRepository.save(student);
//    }
    @Test
    //Check that repository was invoked with the same student that we passed
    void CanAddStudent() {
        // given
        Student student = new Student("Jamila", "jamila@gmail.com", Gender.FEMALE);

        // when
        underTest.addStudent(student);

        // then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        //We want to verify that the repository was called with 'save' and we want to capture the actual student we just passed inside of the 'save' method
        verify(studentRepository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void willThrownExceptionWhenEmailIsTaken() {
        // given
        Student student = new Student("Jamila", "jamila@gmail.com", Gender.FEMALE);

        given(studentRepository.selectExistsEmail(anyString()))
        //given(studentRepository.selectExistsEmail(student.getEmail()))
                .willReturn(true);

        // when
        // then

        assertThatThrownBy( ()-> underTest.addStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + student.getEmail() + " taken");
        //now verify that the method never returns because the exception
        verify(studentRepository, never()).save(any());
    }

    @Test //is ok...?
    void canDeleteStudent() {
//        Student student = new Student("Jamila", "jamila@gmail.com", Gender.FEMALE);
//        student.setId(1l);
    //   underTest.addStudent(student);

        given(studentRepository.existsById(anyLong()))
                .willReturn(true);

        // when
        underTest.deleteStudent(3l);

        // then
        verify(studentRepository).deleteById(3l);

    }

//    //BORRAR: !!!!
//    public void deleteStudent(Long studentId) {
//        if(!studentRepository.existsById(studentId)) {
//            throw new StudentNotFoundException(
//                    "Student with id " + studentId + " does not exists");
//        }
//        studentRepository.deleteById(studentId);
//    }

    @Test //is ok...?
    void  willThrownExceptionWhenIdDoesntExists() {
        // given
        Student student = new Student("Jamila", "jamila@gmail.com", Gender.FEMALE);
        student.setId(3l);

        given(studentRepository.existsById(anyLong()))
                .willReturn(false);
        // when
        // then
            //first we can verify that the method will thrown StudentNotFoundException
        assertThatThrownBy( ()-> underTest.deleteStudent(student.getId()))
                .isInstanceOf(StudentNotFoundException.class)
                .hasMessageContaining("Student with id " + student.getId() + " does not exists");
            //second we verify that the method never finish because the exception
        verify(studentRepository, never()).deleteById(student.getId());
    }
}