package _SpringBoot_SA2_Ficheros.Fichero.infrastructure;

import _SpringBoot_SA2_Ficheros.Fichero.application.DTOs.FicheroInputDTO;
import _SpringBoot_SA2_Ficheros.Fichero.application.DTOs.FicheroOutputDTO;
import _SpringBoot_SA2_Ficheros.Fichero.application.FicheroServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;


@Controller
public class FicheroController {

    @Autowired
    FicheroServiceImpl ficheroService;

    private static final  String classpath = "src/main/resources/uploadedFiles/";
    private Gson gson = new Gson();

    @GetMapping("/upload")
    public String index (Model model, @RequestParam(value = "path", required = false) String pathParam) {
          model.addAttribute("path", pathParam);
        return "upload";
    }


    @PostMapping("/uploading")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             RedirectAttributes attributes,
                             @RequestParam("metadata") String metadata,
                             @RequestParam(name = "path",  required = false, defaultValue = classpath) String pathParam)
            throws Exception {

        if(file == null || file.isEmpty()){
            attributes.addFlashAttribute("message", "No ha seleccionado ningún archivo.");
            return "redirect:status";
        }

        Path pathFinal = Paths.get(pathParam+file.getOriginalFilename());  //createFilePathUpload(file.getOriginalFilename(), pathParam);

        //Obtenemos los bytes del archivo subido
        byte[] fileBytes = file.getBytes();

        //Ecribimos los bytes del archivo
        Files.write(pathFinal, fileBytes);
        System.out.println("archivo subido ---> " + pathFinal.toAbsolutePath());

        attributes.addFlashAttribute("message", "Archivo cargado correctamente");

        //Añadimos un mensaje para ver el fichero en formato de Output
        FicheroOutputDTO ficheroOutputDTO = ficheroService.addFichero(new FicheroInputDTO(file.getOriginalFilename(), pathFinal.toAbsolutePath().toString(), metadata, new Date()));

        attributes.addFlashAttribute("message2", gson.toJson(ficheroOutputDTO));
        //Añadimos otro mensaje para ver todos los ficheros subidos
        attributes.addFlashAttribute("message3", gson.toJson(ficheroService.getAllFicheros()));

        return "redirect:/status";
    }


    @GetMapping("/status")
    public String getStatus(){
        return "status";
    }

    @GetMapping("/exceptions")
    public String getException(){
        return "exceptions";
    }
}