package bitlab.spring.jpa.crm_system.repositories;

import bitlab.spring.jpa.crm_system.models.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequest, Long> {
}
