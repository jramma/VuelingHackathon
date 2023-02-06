package es.vueling.demo.repository;

import es.vueling.demo.domain.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TripRepo extends MongoRepository<Trip, String> {

    List<Trip> findByCitiesContaining(String city);
}
