package rush.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rush.domain.TestDomain;
import rush.repository.TestDomainRepository;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    final TestDomainRepository testDomainRepository;

    @GetMapping("/hello")
    public TestDomain hello(){

        TestDomain testDomain=testDomainRepository.save(new TestDomain().builder()
            .title("하이하이")
            .content("이건 내용입니다")
            .build());
         TestDomain testDomain2 = testDomainRepository.findById(testDomain.getId())
             .orElseThrow(()->new IllegalArgumentException("id가 없습니다"));


        return testDomain2;
    }

}
