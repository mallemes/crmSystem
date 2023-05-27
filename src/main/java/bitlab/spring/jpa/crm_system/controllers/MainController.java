package bitlab.spring.jpa.crm_system.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
//        ArrayList<Student> students = DBManager.getStudents();
//        model.addAttribute("students", students);
        return "index";
    }
}
