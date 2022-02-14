package _SpringBoot_SA2_Ficheros.Fichero.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Date;

public interface FicheroRepository extends JpaRepository<Fichero, Long> {

    List<Fichero> findByName(String name);

//    List<Fichero> findByuploadDate(Date date);
//
//    Fichero findById(long id);
//
//    List<Fichero> findAll();
}
