package com.springboot.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// which marks the class as a controller where every method returns a domain object instead of a view.
@RestController // @RestController = @Controller + @ResponseBody
public class HelloWorldController {
    // GET HTTP Method
    // http://localhost:8080/hello-world

    // dạng viết tắt của @RequestMapping(method = RequestMethod.GET)
    // mapping HTTP GET requests onto specific handler methods.
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hoàng Anh Tiến!";
    }
}
