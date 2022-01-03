package com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application;

import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.application.dto.output.Estudiante_AsignaturaDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.domain.Estudiante_Asignatura;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Estudiante_Asignatura.domain.Estudiante_AsignaturaRepository;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.input.StudentDTOinput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output.StudentDTOoutputFull;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.application.dto.output.StudentDTOoutput;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.Student;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.Student.domain.StudentRepository;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.NotFoundException;
import com.Practicas._SpringBoot_JPA_Hibernate_CRUD.common.UnprocesableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IStudentService implements StudentServiceInterface{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    Estudiante_AsignaturaRepository estudianteAsignaturaRepository;

    @Override
    public List<StudentDTOoutput> toListDTOoutput(List<Student> students) {
        List<StudentDTOoutput> studentDTOoutputs = new ArrayList();

        for(Student s: students){
            studentDTOoutputs.add(new StudentDTOoutput(s));
        }

        return studentDTOoutputs;
    }


    //GET
    @Override
    public StudentDTOoutput getStudentById(String id, String type) throws Exception {
        Student student = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("No existe estudiante con id:" + id));

        if (type.equalsIgnoreCase("full")){
            return new StudentDTOoutputFull(student);
        }

        return new StudentDTOoutput(student);
    }

    @Override
    public List<StudentDTOoutput> getStudentsByName(String name) throws Exception {

        if (studentRepository.findByPersona(name).isEmpty()) { throw  new NotFoundException("No hay ningún estudiante con nombre: " + name + ".");}
        List<Student> students = studentRepository.findByPersona(name);

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


    @Override
    public StudentDTOoutput addAsignaturaToStudent(String id_estud, String id_student_asig) throws Exception {
        if(studentRepository.findById(id_estud).isEmpty()){throw new NotFoundException("Estudiante con ID: " + id_estud + " no existe.");}
        if(estudianteAsignaturaRepository.findById(id_student_asig).isEmpty()){ throw new NotFoundException("Estudiante_Asignatura con ID: " + id_student_asig + " no existe.");}

        Student student = studentRepository.findById(id_estud).get();
        Estudiante_Asignatura estudiante_asignatura = estudianteAsignaturaRepository.findById(id_student_asig).get();

        student.getAsignaturas().add(estudiante_asignatura);

        estudiante_asignatura.getStudents().add(student);

        estudianteAsignaturaRepository.saveAndFlush(estudiante_asignatura);

        studentRepository.saveAndFlush(student);
        //estudianteAsignaturaRepository.saveAndFlush(estudiante_asignatura);

        return new StudentDTOoutput(student);
    }

    @Override
    public StudentDTOoutput addAsignaturasToStudent(String id_estud, List<String> ids_Asig) throws Exception {
        if(studentRepository.findById(id_estud).isEmpty()){ throw new NotFoundException("Estudiante con id: " + id_estud +" no existe.");}

        Student student = studentRepository.findById(id_estud).get();


        for (String id_Asignatura: ids_Asig) {
            Optional<Estudiante_Asignatura> estudiante_asignatura = estudianteAsignaturaRepository.findById(id_Asignatura);

            if(estudiante_asignatura.isEmpty()){ throw new NotFoundException("No existe asignatura");}
            else{
                student.getAsignaturas().add(estudiante_asignatura.get());
                //  OJO Si no se hace esto, no funciona.....
                estudiante_asignatura.get().getStudents().add(student);
            }
        }

        studentRepository.saveAndFlush(student);

        return new StudentDTOoutput(student);
    }

    @Override
    public StudentDTOoutput deleteAsignaturasFromStudent(String id_estud, List<String> ids_Asig) throws Exception {
        if(studentRepository.findById(id_estud).isEmpty()){ throw new NotFoundException("Estudiante con id: " + id_estud +" no existe.");}

        Student student = studentRepository.findById(id_estud).get();

        for (String id_Asignatura: ids_Asig) {
            Optional<Estudiante_Asignatura> estudiante_asignatura = estudianteAsignaturaRepository.findById(id_Asignatura);

            if(estudiante_asignatura.isEmpty()){ throw new NotFoundException("No existe asignatura con ID: " + ids_Asig);}
            else{
                //UF...
                student.getAsignaturas().remove(estudiante_asignatura.get());

                estudiante_asignatura.get().getStudents().remove(student);
            }
        }

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