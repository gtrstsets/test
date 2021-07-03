package rush.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rush.domain.TestDomain;
import rush.dto.TestRequest;
import rush.repository.TestDomainRepository;

@Service
@RequiredArgsConstructor
public class TestService {

    final TestDomainRepository testDomainRepository;

    public Long createTest(){
        TestDomain testDomain=testDomainRepository.save(new TestDomain().builder()
            .title("하이하이")
            .content("이건 내용입니다")
            .build());

        return testDomain.getId();
    }

    public TestRequest findTest(Long id){

        TestDomain testDomain = testDomainRepository.findById(id)
            .orElseThrow(()->new IllegalArgumentException("id가 없습니다"));

        TestRequest testRequest= new TestRequest(
            testDomain.getId(),
            testDomain.getTitle(),
            testDomain.getContent(),
            testDomain.getCreateDate());
        return testRequest;
    }
}
