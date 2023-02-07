package es.vueling.demo.service;

import es.vueling.demo.domain.City;
import es.vueling.demo.domain.Trip;
import es.vueling.demo.repository.CityRepo;
import es.vueling.demo.repository.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class VuelingService {
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private TripRepo tripRepo;
    @Autowired
    private MongoTemplate mongoTemplate;
    /*
    He hecho las querys de dos maneras diferentes porque se puede,
    no es necesario, ni una es más rápida que la otra. Tienes un método de query
    en la Interface CityRepo y la otra es con el MongoTemplate en findTripsByCity()
     */
    public void test() {
        cityRepo.findByNameContainingIgnoreCase("mad");


    }
    public List<String> getCity(String city) {
        //it dosen´t matter if city length is 3 or more but always will be more or equal than
        // 3 because of the validation in the html
        return cityRepo.findByNameContainingIgnoreCase(city);
    }

    public List<Trip> findTripsByCity(String city) {
        Query query = new Query();
        query.addCriteria(Criteria.where("cities").in(city));
        System.out.println(query);
        List<Trip> trips = mongoTemplate.find(query, Trip.class);
        System.out.println(trips);
        return trips;
    }

    public City addCity(City city) {
        return cityRepo.save(city);
    }


    public Trip addTrip(Trip trip) {
       return tripRepo.save(trip);
    }
}

// Author: peperamos.cat