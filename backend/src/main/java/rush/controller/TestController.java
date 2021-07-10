package rush.controller;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rush.dto.TestRequest;
import rush.service.TestService;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {


    final TestService testService;

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody TestRequest testRequest){
        TestRequest test = testService.createTest(testRequest);
//dsadasdasdsad
        return ResponseEntity.status(201).build();
    }


    @GetMapping("/hello")
    public ResponseEntity<TestRequest> hello(@RequestParam Long id){

        return ResponseEntity.ok().body(testService.findTest(id));
    }

}
