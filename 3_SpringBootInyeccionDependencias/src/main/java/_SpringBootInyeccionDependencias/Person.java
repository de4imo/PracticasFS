package _SpringBootInyeccionDependencias;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
//@Component
public class Person {
    private String name;
    private String city;
    private Integer age;
}
