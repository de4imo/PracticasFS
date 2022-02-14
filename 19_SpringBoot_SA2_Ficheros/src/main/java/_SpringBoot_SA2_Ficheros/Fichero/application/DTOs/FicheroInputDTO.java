package _SpringBoot_SA2_Ficheros.Fichero.application.DTOs;

import _SpringBoot_SA2_Ficheros.Fichero.domain.Fichero;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class FicheroInputDTO {

    private String name;

    private String path;

    private String metadata;

    private Date uploadDate;

    public Fichero toEntity(){
        Fichero fichero = new Fichero();

        fichero.setName(this.getName());
        fichero.setPath(this.getPath());
        fichero.setMetadata(this.getMetadata());
        fichero.setUploadDate(this.getUploadDate());

        return fichero;
    }
}
