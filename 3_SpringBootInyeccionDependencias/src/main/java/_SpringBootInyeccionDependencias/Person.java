package _SpringBootInyeccionDependencias;

import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
//@Component         //lo comento porque ahora para compartir esta clase se utiliza @Bean en Application, (apartado 2 del ejercicio)
public class Person {
    private String name;
    private String city;
    private Integer age;
}
