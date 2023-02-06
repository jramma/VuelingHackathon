package es.vueling.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "trips")
public abstract class Trip {
    private String tripName;
    private String typeOfTrip;
    private String duration;
    private String [] cities;
    private String specificDetails;

}
