package _SpringBootInyeccionDependencias;

import java.util.List;

public interface PersonService {

    Person getPerson();
    void setPerson(Person persona);

    List<City> getCities();
    void setCities(List<City> cities);
}
