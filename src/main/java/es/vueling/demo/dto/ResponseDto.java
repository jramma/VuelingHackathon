package es.vueling.demo.dto;

import es.vueling.demo.domain.Trip;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseDto {
    private String response;
    private Set<Trip> trips;

}
// Author: peperamos.cat