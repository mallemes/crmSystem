package bitlab.spring.jpa.crm_system.controllers;

import bitlab.spring.jpa.crm_system.models.ApplicationCourse;
import bitlab.spring.jpa.crm_system.models.ApplicationRequest;
import bitlab.spring.jpa.crm_system.services.ApplicationCourseService;
import bitlab.spring.jpa.crm_system.services.ApplicationRequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {

    private final ApplicationRequestService requestService;
    private final ApplicationCourseService courseService;

    @GetMapping("/")
    public String index(Model model) {
        List<ApplicationRequest> requests = requestService.allRequests();
        model.addAttribute("requests", requests);
        return "index";
    }

    @GetMapping("/add-request")
    public String addRequest(Model model) {
        List<ApplicationCourse> courses = courseService.allCourses();
        model.addAttribute("courses", courses);
        return "add-request";
    }

    @PostMapping("/add-request")
    public String addRequest(ApplicationRequest request) {
        requestService.save(request);
        return "redirect:/";
    }
}
