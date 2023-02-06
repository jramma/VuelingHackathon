package es.vueling.demo.dto;

public class AirTrip extends Trip {

        public AirTrip(String name, String cities, String details, String duration) {
            super(name, cities, details, duration);
        }

        @Override
        String getType() {
            return "Air Trip";
        }
}

