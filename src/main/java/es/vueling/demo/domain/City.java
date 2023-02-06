package es.vueling.demo.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "cities")
public class City {
    private String name;
}
