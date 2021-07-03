package rush.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rush.domain.TestDomain;

public interface TestDomainRepository extends JpaRepository<TestDomain, Long> {

}
