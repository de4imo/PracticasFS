package _SpringBootInyeccionDependencias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

    Person persona = new Person();

    public void setPerson(Person per){
        persona = per;
    }

    public Person getPerson(){
        return persona;
    }
}
