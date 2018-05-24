package it.gunnegan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
@SpringBootApplication
@EnableAutoConfiguration
public class RugbyFloApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
      return "Hello World!";
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
            String retString = "Funziona ";
            return new ResponseEntity<String>(retString, HttpStatus.OK);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RugbyFloApplication.class, args);
    }

}