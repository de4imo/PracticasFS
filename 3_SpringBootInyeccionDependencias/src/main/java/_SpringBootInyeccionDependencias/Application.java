package _SpringBootInyeccionDependencias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	PersonServiceImpl getPersonService(){
		PersonServiceImpl p = new PersonServiceImpl();

		List<City> listaCiudades = new ArrayList<>();

		listaCiudades.add(new City("Roma", 123456));
		listaCiudades.add(new City("Berlin", 122222));

		p.setCities(listaCiudades);
		return p;
	}
}
