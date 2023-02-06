package es.vueling.demo.controller;


import es.vueling.demo.domain.City;
import es.vueling.demo.domain.Trip;
import es.vueling.demo.repository.CityRepo;
import es.vueling.demo.service.VuelingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.result.view.RedirectView;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vueling/api")
public class QueryController {
    @Autowired
    private VuelingService vuelingService;

    @GetMapping("/test")
    public String test() {
        return "Hello from Vueling!!!";
    }

    @GetMapping("/search")
    public RedirectView redirectToSearchPage() {
        return new RedirectView("http://localhost:9797/search.html");
    }

    @GetMapping("/search/{place}")
    public String getPlace(@PathVariable String place) {
        String answer = "";
        ArrayList<List<Trip>> trips = new ArrayList<>();
        List<String> cities = vuelingService.getCity(place);
        if (cities.size() == 0) {
            answer = "City not found";
        } else {
            for (int i = 0; i < cities.size(); i++) {
                trips.add(vuelingService.getTrip(cities.get(i)));

            }
            answer = trips.toString();
        }

        return answer;

    }
}
