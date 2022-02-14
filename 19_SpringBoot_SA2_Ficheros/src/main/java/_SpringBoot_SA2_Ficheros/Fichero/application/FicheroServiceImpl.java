package _SpringBoot_SA2_Ficheros.Fichero.application;

import _SpringBoot_SA2_Ficheros.Fichero.application.DTOs.FicheroInputDTO;
import _SpringBoot_SA2_Ficheros.Fichero.application.DTOs.FicheroOutputDTO;
import _SpringBoot_SA2_Ficheros.Fichero.domain.Fichero;
import _SpringBoot_SA2_Ficheros.Fichero.domain.FicheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FicheroServiceImpl implements FicheroServiceIntf{

    @Autowired
    FicheroRepository ficheroRepository;

    @Override
    public FicheroOutputDTO getFicheroById(long id) throws Exception {
        Fichero fichero = ficheroRepository.findById(id).orElseThrow(() -> new CustomException("No existen ficheros con id \"" + id + "\""));

        return new FicheroOutputDTO(fichero);
    }

    @Override
    public List<FicheroOutputDTO> getFicherosByName(String name) throws Exception {
        List<Fichero> ficheros = ficheroRepository.findByName(name);

        if(ficheros.isEmpty() || ficheros == null)
            throw new CustomException("No existen ficheros con nombre: \"" + name+ "\".");

        return toListOutputDTO(ficheros);
    }

    @Override
    public List<FicheroOutputDTO> getAllFicheros() throws Exception {
        List<Fichero> ficheros = ficheroRepository.findAll();

        if(ficheros.isEmpty() || ficheros == null)
            throw new CustomException("No existe ningún fichero.");

        return toListOutputDTO(ficheros);
    }

    @Override
    public FicheroOutputDTO addFichero(FicheroInputDTO ficheroInputDTO) throws Exception {
        if (!isValid(ficheroInputDTO))
            throw new CustomException("El fichero no es válido.");

        Fichero fichero = ficheroInputDTO.toEntity();

        ficheroRepository.saveAndFlush(fichero);

        return new FicheroOutputDTO(fichero);
    }

    @Override
    public List<FicheroOutputDTO> addFicheros(List<FicheroInputDTO> ficherosInputDTOs) throws Exception {

        List<Fichero> ficheros = new ArrayList<>();

        for(FicheroInputDTO ficheroInputDTO: ficherosInputDTOs){
            if (!isValid(ficheroInputDTO))
                throw new CustomException("El fichero no es válido.");
            else
                ficheros.add(ficheroInputDTO.toEntity());
        }

        for(Fichero fichero: ficheros){
            ficheroRepository.saveAndFlush(fichero);
        }

        return toListOutputDTO(ficheros);
    }


    @Override
    public List<FicheroOutputDTO> toListOutputDTO(List<Fichero> ficheros){
        List<FicheroOutputDTO> ficherosOutputDTO = new ArrayList();

        for(Fichero p: ficheros){
            ficherosOutputDTO.add(new FicheroOutputDTO(p));
        }
        return ficherosOutputDTO;
    }

    @Override
    public boolean isValid(FicheroInputDTO ficheroInputDTO){
        if (ficheroInputDTO == null)
            return false;
        if (ficheroInputDTO.getName() == null)
            return false;
        return true;
    }
}
