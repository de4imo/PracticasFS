package _SpringBoot_SA2_Ficheros.Fichero.application;

import _SpringBoot_SA2_Ficheros.Fichero.application.DTOs.FicheroInputDTO;
import _SpringBoot_SA2_Ficheros.Fichero.application.DTOs.FicheroOutputDTO;
import _SpringBoot_SA2_Ficheros.Fichero.domain.Fichero;

import java.util.List;

public interface FicheroServiceIntf {
    FicheroOutputDTO getFicheroById(long id) throws Exception;

    List<FicheroOutputDTO> getFicherosByName(String name) throws Exception;

    List<FicheroOutputDTO> getAllFicheros() throws Exception;

    FicheroOutputDTO addFichero (FicheroInputDTO ficheroInputDTO) throws Exception;

    List<FicheroOutputDTO> addFicheros (List<FicheroInputDTO> ficheroInputDTO) throws Exception;

    List<FicheroOutputDTO> toListOutputDTO (List<Fichero> ficheros);

    boolean isValid(FicheroInputDTO ficheroInputDTO);
}
