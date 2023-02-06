package es.vueling.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDto {
    private String tripName;
    private String typeOfTrip;
    private String duration;
    private String[] nameofCities;
    private String details;




}