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

    public TestRequest createTest(TestRequest testRequest){
        TestDomain testDomain = testDomainRepository.save(new TestDomain().builder()
            .title(testRequest.getTitle())
            .content(testRequest.getContent())
            .build());

        return new TestRequest(
            testDomain.getId(),
            testDomain.getTitle(),
            testDomain.getContent(),
            testDomain.getCreateDate());
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
