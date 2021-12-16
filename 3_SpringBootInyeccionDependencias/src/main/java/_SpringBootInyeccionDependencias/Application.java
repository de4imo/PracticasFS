package _SpringBootInyeccionDependencias;

import org.springframework.beans.factory.annotation.Qualifier;
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


	//Parece que es lo mismo Bean(name = "bean1")  que poner el @Qualifier y el @Bean
	@Bean(name = "bean1")
	Person getPerson1(){
		Person p = new Person("Pepe", "Caceres", 22);
		return p;
	}


	@Qualifier("bean2")
	@Bean
	Person getPerson2(){
		Person p =  new Person("Luisa", "Burgos", 33);
		return p;
	}
	@Qualifier("bean3")
	@Bean
	Person getPerson3(){
		Person p = new Person("Pedro", "Avila", 44);
		return p;
	}

}
