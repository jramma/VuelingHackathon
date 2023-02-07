package es.vueling.demo.controller;


import es.vueling.demo.domain.City;
import es.vueling.demo.domain.Trip;
import es.vueling.demo.dto.ResponseDto;
import es.vueling.demo.repository.CityRepo;
import es.vueling.demo.service.VuelingService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.view.RedirectView;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public ResponseDto getPlace(@PathVariable String place) {
        String answer = "";
        ArrayList <String> cities = (ArrayList<String>) vuelingService.getCity(place);
       List <Trip> trips = new ArrayList<>();

        if (cities.isEmpty()) {
            answer = "City not found";
        } else {
            answer = "Trips found";
            for(int i= 0; i < cities.size(); i++) {
                String cityName = extractCityName(cities.get(i));
                trips.addAll( vuelingService.findTripsByCity(cityName));
            }
            }
        /*
        Esto es para que no se repitan los viajes, porque por ejemplo, si el usuario escribe
        "lon" la api bucará ciudades que contengan "lon" y puede ser
        que haya viajes con London y Londres y cualquier idioma que quieras añadir a la base de
        dato a través de los endpoint post
         */


        Set<Trip> uniqueTrips = new HashSet<>(trips);
        if(uniqueTrips.isEmpty()){
            answer = "No trips found";
        }

        return new ResponseDto(answer, uniqueTrips);

    }
    public String extractCityName(String cityJson) {
        /*
        Esto es porque sino no busca el String "Madrid" por ejemplo
        sino que buscaría el objeto City Madrid con su id y eso no está en
        Trips entonces no tendríamos respuesta y yo quiero que me compare
        los String
         */

        try {
            JSONObject city = new JSONObject(cityJson);
            return city.getString("name");
        } catch (JSONException e) {
            return "";
        }
    }
    @PostMapping("/addCity")
    public ResponseEntity<String> createCity(@RequestBody City city) {
        vuelingService.addCity(city);
        return ResponseEntity.ok("City added: " + city.toString());
    }
    @PostMapping("/addTrip")
    public ResponseEntity<String> createCity(@RequestBody Trip trip) {
        vuelingService.addTrip(trip);
        return ResponseEntity.ok("Trip added: " + trip.toString());
    }
}
// Author: peperamos.cat