package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.aplication.dto.output.PersonaDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Persona.domain.Persona;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.input.StudentDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output.StudentDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.StudentRepository;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.NotFoundException;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class IStudentService implements StudentServiceInterface{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<StudentDTOoutput> toListDTOoutput(List<Student> students) {
        List<StudentDTOoutput> studentDTOoutputs = new ArrayList();

        for(Student s: students){studentDTOoutputs.add(new StudentDTOoutput(s));}

        return studentDTOoutputs;
    }


    //GET
    @Override
    public StudentDTOoutput getStudentById(String id) throws Exception {
        Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe estudiante con id:" + id));
        return null;
    }

    @Override
    public List<StudentDTOoutput> getStudentsByName(String name) throws Exception {

        if (studentRepository.findByName(name).isEmpty()) { throw  new NotFoundException("No hay ningún estudiante con nombre: " + name + ".");}
        List<Student> students = studentRepository.findByName(name);

        return toListDTOoutput(students);
    }

    @Override
    public List<StudentDTOoutput> getAllStudents() throws Exception {
        List<Student> students = studentRepository.findAll();
        if(students.isEmpty()){ throw new NotFoundException("No hay estudiantes.");}

        return toListDTOoutput(students);
    }

    //POST
    @Override
    public StudentDTOoutput addStudent(StudentDTOinput studentDTOinput) throws Exception {
        if(studentDTOinput == null){throw new UnprocesableException("Estudiante enviado es nulo.");}
        //if(studentDTOinput.getName().length()<6 || pers.getName().length()>10){throw new UnprocesableException("UnprocesableException: Persona enviada tiene un nombre cuya longitud no está entre 6 y 10 caracteres."); }

        Student student= studentDTOinput.toEntity();

        studentRepository.saveAndFlush(student);

        return new StudentDTOoutput(student);
    }

    //PUT
    @Override
    public StudentDTOoutput updateStudent(StudentDTOinput studentDTOinput, String id) throws Exception {
        if(studentRepository.findById(id).isEmpty()){throw new NotFoundException("No existe estudiante con id:" + id);}
//      if(studentDTOinput.getName().length()<6 || studentDTOinput.getName().length()>10){throw new UnprocesableException("UnprocesableException: Persona enviada tiene un nombre cuya longitud no está entre 6 y 10 caracteres.");}

        Student student = studentDTOinput.toEntity();
        student.setId_student(id);
        studentRepository.saveAndFlush(student);

        return new StudentDTOoutput(student);
    }

    //DELETE
    @Override
    public void deleteStudent(String id) throws Exception {
        if(studentRepository.findById(id).isEmpty()){throw new NotFoundException("No existe estudiante con id:" + id);}
        studentRepository.delete(studentRepository.findById(id).get());
    }
}