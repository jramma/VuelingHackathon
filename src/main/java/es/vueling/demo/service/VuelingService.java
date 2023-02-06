package es.vueling.demo.service;

import es.vueling.demo.domain.Trip;
import es.vueling.demo.repository.CityRepo;
import es.vueling.demo.repository.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class VuelingService {
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private TripRepo tripRepo;

    public void test() {
        cityRepo.findByNameContainingIgnoreCase("mad");
        tripRepo.findByCitiesContaining("Madrid");
    }
    public List<String> getCity(String city) {
        //it dosen´t matter if city length is 3 or more but always will be more or equal than
        // 3 because of the validation in the html
        return cityRepo.findByNameContainingIgnoreCase(city);
    }

    public List<Trip> getTrip(String city) {

        return tripRepo.findByCitiesContaining(city);
    }

}
