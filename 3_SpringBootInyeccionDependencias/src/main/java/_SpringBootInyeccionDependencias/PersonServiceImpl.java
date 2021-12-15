package _SpringBootInyeccionDependencias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service lo comento porque ahora se utiliza @Beans en Application, apartado 2
public class PersonServiceImpl implements PersonService{

    Person persona = new Person();
    List<City> cities;

    public void setPerson(Person per){persona = per;}
    public Person getPerson(){return persona;}

    public void setCities(List<City> cities){this.cities = cities;}
    public List<City> getCities(){return cities;}
}
