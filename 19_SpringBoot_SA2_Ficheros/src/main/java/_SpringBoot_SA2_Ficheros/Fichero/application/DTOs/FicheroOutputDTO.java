package _SpringBoot_SA2_Ficheros.Fichero.application.DTOs;

import _SpringBoot_SA2_Ficheros.Fichero.domain.Fichero;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class FicheroOutputDTO {
    private long id;

    private String name;

    private String path;

    private String metadata;

    private Date uploadDate;

    public FicheroOutputDTO(Fichero fichero){
        this.id = fichero.getId();
        this.name = fichero.getName();
        this.path = fichero.getPath();
        this.metadata = fichero.getMetadata();
        this.uploadDate = fichero.getUploadDate();
    }
}
