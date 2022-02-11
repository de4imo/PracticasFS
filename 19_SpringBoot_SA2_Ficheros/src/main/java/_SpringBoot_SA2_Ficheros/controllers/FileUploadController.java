package _SpringBoot_SA2_Ficheros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {

    @GetMapping("/")
    public String index () {
        return "upload";
    }

//    @GetMapping("/uploadFile")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "demo";
//    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes)
            throws IOException {

        if(file == null || file.isEmpty()){
            attributes.addFlashAttribute("message", "No ha seleccionado ningún archivo.");
            return "redirect:status";
        }

        //Creamos la ruta del archivo donde se guardará lo que se suba (en HOME)
        //Path path = createFilePathUpload(file.getOriginalFilename());

        //Creamos la ruta del archivo donde se guardará lo que se suba (en en el classpath)
        Path path = createFilePathUploadInClassPath(file.getOriginalFilename());

        //Obtenemos los bytes del archivo subido
        byte[] fileBytes = file.getBytes();

        //Ecribimos los bytes del archivo
        Files.write(path, fileBytes);

        attributes.addFlashAttribute("message", "Archivo cargado correctamente ["
                + file.getOriginalFilename() +"] ["
                + path.toString() + "]");

        return "redirect:/status";
    }


    @GetMapping("/status")
    public String getStatus(){
        return "status";
    }

    private Path createFilePathUploadInClassPath(String filename){

        String classpath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources"  + File.separator
                + "uploadedFiles"
                + File.separator
                + filename;

        return Paths.get(classpath);
    }

    private Path createFilePathUpload(String filename){
        StringBuilder builder = new StringBuilder ();

        builder.append(System.getProperty("user.home"));
        builder.append(File.separator);
        builder.append("spring_upload");
        builder.append(File.separator);
        builder.append(filename);

        return Paths.get(builder.toString());
    }
}
