package es.vueling.demo.repository;

import es.vueling.demo.domain.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TripRepo extends MongoRepository<Trip, String> {

//    @Query(value = "{ 'cities' : {$all : [?0] }}")
//    List<Trip> findAnyOfTheseValues(String[] cities);


}
// Author: peperamos.cat