package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.input.StudentDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output.StudentDTOoutputFull;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output.StudentDTOoutputSimple;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.StudentRepository;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.NotFoundException;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IStudentService implements StudentServiceInterface{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<StudentDTOoutputSimple> toListDTOoutput(List<Student> students) {
        List<StudentDTOoutputSimple> studentDTOoutputSimples = new ArrayList();

        for(Student s: students){
            studentDTOoutputSimples.add(new StudentDTOoutputSimple(s));}

        return studentDTOoutputSimples;
    }


    //GET
    @Override       //Habrá otra forma que no sea con Object?
    public Object getStudentById(String id, String type) throws Exception {
        Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe estudiante con id:" + id));

        if(type.equalsIgnoreCase("simple")){
            return new StudentDTOoutputSimple(student);
        }else if (type.equalsIgnoreCase("full")){
            return new StudentDTOoutputFull(student);
        }

        return null;
    }

    @Override
    public List<StudentDTOoutputSimple> getStudentsByName(String name) throws Exception {

        if (studentRepository.findByPersona(name).isEmpty()) { throw  new NotFoundException("No hay ningún estudiante con nombre: " + name + ".");}
        List<Student> students = studentRepository.findByPersona(name);

        return toListDTOoutput(students);
    }

    @Override
    public List<StudentDTOoutputSimple> getAllStudents() throws Exception {
        List<Student> students = studentRepository.findAll();
        if(students.isEmpty()){ throw new NotFoundException("No hay estudiantes.");}

        return toListDTOoutput(students);
    }

    //POST
    @Override
    public StudentDTOoutputSimple addStudent(StudentDTOinput studentDTOinput) throws Exception {
        if(studentDTOinput == null){throw new UnprocesableException("Estudiante enviado es nulo.");}
        //if(studentDTOinput.getName().length()<6 || pers.getName().length()>10){throw new UnprocesableException("UnprocesableException: Persona enviada tiene un nombre cuya longitud no está entre 6 y 10 caracteres."); }

        Student student= studentDTOinput.toEntity();

        studentRepository.saveAndFlush(student);

        return new StudentDTOoutputSimple(student);
    }

    //PUT
    @Override
    public StudentDTOoutputSimple updateStudent(StudentDTOinput studentDTOinput, String id) throws Exception {
        if(studentRepository.findById(id).isEmpty()){throw new NotFoundException("No existe estudiante con id:" + id);}
//      if(studentDTOinput.getName().length()<6 || studentDTOinput.getName().length()>10){throw new UnprocesableException("UnprocesableException: Persona enviada tiene un nombre cuya longitud no está entre 6 y 10 caracteres.");}

        Student student = studentDTOinput.toEntity();
        student.setId_student(id);
        studentRepository.saveAndFlush(student);

        return new StudentDTOoutputSimple(student);
    }

    //DELETE
    @Override
    public void deleteStudent(String id) throws Exception {
        if(studentRepository.findById(id).isEmpty()){throw new NotFoundException("No existe estudiante con id:" + id);}
        studentRepository.delete(studentRepository.findById(id).get());
    }
}