package bitlab.spring.jpa.crm_system.services;

import bitlab.spring.jpa.crm_system.models.ApplicationCourse;
import bitlab.spring.jpa.crm_system.models.ApplicationRequest;
import bitlab.spring.jpa.crm_system.repositories.ApplicationCourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationCourseService {
    private final ApplicationCourseRepository courseRepository;

    public List<ApplicationCourse> allCourses() {
        return courseRepository.findAll();
    }

    public ApplicationCourse getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }
}
