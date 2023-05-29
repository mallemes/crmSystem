package bitlab.spring.jpa.crm_system.controllers;

import bitlab.spring.jpa.crm_system.models.ApplicationCourse;
import bitlab.spring.jpa.crm_system.models.ApplicationRequest;
import bitlab.spring.jpa.crm_system.services.ApplicationCourseService;
import bitlab.spring.jpa.crm_system.services.ApplicationRequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/request-details/{requestId}")
    public String requestDetails(@PathVariable Long requestId ,Model model){
        List<ApplicationCourse> courses = courseService.allCourses();
        ApplicationRequest request = requestService.getRequestById(requestId);
        if (request == null){
            return "pageNotFound";
        }
        model.addAttribute("request", request);
        model.addAttribute("courses", courses);
        return "request-detail";
    }
    @PostMapping("/delete-request/{requestId}")
    public  String deleteRequest(@PathVariable Long requestId){
        requestService.deleteRequest(requestId);
        return "redirect:/";
    }
    @PostMapping("/update/request")
    public  String updateRequest(ApplicationRequest request){
        request.setHandled(true);
        requestService.save(request);
        return "redirect:/";
    }

}
