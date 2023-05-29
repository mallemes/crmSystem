package bitlab.spring.jpa.crm_system.services;

import bitlab.spring.jpa.crm_system.models.ApplicationRequest;
import bitlab.spring.jpa.crm_system.repositories.ApplicationCourseRepository;
import bitlab.spring.jpa.crm_system.repositories.ApplicationRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationRequestService {
    private final ApplicationRequestRepository applicationRequestRepository;

    public List<ApplicationRequest> allRequests(){
        return applicationRequestRepository.findAll();
    }
    public ApplicationRequest getRequestById(Long id){
        return applicationRequestRepository.findById(id).orElse(null);
    }
    public void save(ApplicationRequest request){
        applicationRequestRepository.save(request);
    }
    public  void deleteRequest(Long id){
        applicationRequestRepository.deleteById(id);
    }
}
