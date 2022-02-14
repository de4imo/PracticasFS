package _SpringBoot_SA2_Ficheros.Fichero.infrastructure;

import _SpringBoot_SA2_Ficheros.Fichero.application.CustomException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MultipartException.class)
    public String handleMultipartException(MultipartException e, RedirectAttributes attributes) {
        attributes.addFlashAttribute("message", "Se ha superado el tamaño máximo del fichero y se ha producido la siguiente excepción:\n" + e.getCause().getMessage());

        return "redirect:/status";
    }

    @ExceptionHandler(CustomException.class)
    public String handleException(CustomException e, RedirectAttributes attributes) {
        attributes.addFlashAttribute("errorMessage", "Se ha producido la siguiente excepción:\n" + e.getMessage());

        return "redirect:/exceptions";
    }
}
