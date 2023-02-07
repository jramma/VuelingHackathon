package es.vueling.demo.repository;

import es.vueling.demo.domain.City;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CityRepo extends MongoRepository<City, String> {

    List<String> findByNameContainingIgnoreCase(String name);


}
// Author: peperamos.cat