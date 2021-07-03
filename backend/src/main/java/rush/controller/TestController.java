package rush.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rush.dto.TestRequest;
import rush.service.TestService;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {


    final TestService testService;

    @GetMapping("/hello")
    public TestRequest hello(){

        return testService.findTest(testService.createTest());
    }

}
