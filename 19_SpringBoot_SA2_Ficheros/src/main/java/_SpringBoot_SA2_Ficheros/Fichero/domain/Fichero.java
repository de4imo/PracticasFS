package _SpringBoot_SA2_Ficheros.Fichero.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FICHEROS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fichero {
  //  a. Guardar el fichero y en una tabla el metadato, nombre de fichero, fecha de subida

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    @Column(name = "id",unique = true)
    private long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String path;

    @Column
    @NotNull
    private String metadata;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date uploadDate;
}
