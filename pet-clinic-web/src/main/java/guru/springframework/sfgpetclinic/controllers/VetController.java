package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetController {

    @GetMapping({"/vets/index", "vets/index.html", "/vets"})
    public String vetsList() {

        return "vets/index";
    }

}
