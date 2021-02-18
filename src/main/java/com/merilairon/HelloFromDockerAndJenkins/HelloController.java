package com.merilairon.HelloFromDockerAndJenkins;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello/{message}")
    String hello(@PathVariable("message") String message) {
        return String.format("<h1>Hello from Docker & Jenkins!</h1><p>%s</p>", message);
    }
}
