package _SpringBoot_SA2_Ficheros.Fichero.infrastructure;

import _SpringBoot_SA2_Ficheros.Fichero.application.DTOs.FicheroOutputDTO;
import _SpringBoot_SA2_Ficheros.Fichero.application.FicheroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FicheroRestController {

    @Autowired
    FicheroServiceImpl ficheroService;

    @GetMapping("/allFicheros")
    public List<FicheroOutputDTO> getAll() throws Exception {
        return ficheroService.getAllFicheros();
    }

    @GetMapping("/ficheros")
    public List<FicheroOutputDTO> getByName(@RequestParam("name") String name) throws Exception {
        return ficheroService.getFicherosByName(name);
    }

    @GetMapping("/fichero")
    public FicheroOutputDTO getById(@RequestParam("id") long id) throws Exception {
        return ficheroService.getFicheroById(id);
    }
}
