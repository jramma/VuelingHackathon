package es.vueling.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vueling/api")
public class QueryController {


    @GetMapping("/test")
    public String test() {
        return "Hello from Vueling!!!";
    }
    @GetMapping("/{place}")
    public String getPlace(@PathVariable String place) {




        return "Hello from " + place;
    }




}
