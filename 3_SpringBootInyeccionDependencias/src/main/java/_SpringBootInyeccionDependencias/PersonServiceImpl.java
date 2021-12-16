package _SpringBootInyeccionDependencias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service         //lo comento porque ahora para compartir esta clase se utiliza @Bean en Application, (apartado 2 del ejercicio)
public class PersonServiceImpl implements PersonService{

    Person persona;
    List<City> cities = new ArrayList<>();

    public void setPerson(Person per){persona = per;}
    public Person getPerson(){return persona;}

    public void setCities(List<City> cities){this.cities = cities;}
    public List<City> getCities(){return cities;}
}
