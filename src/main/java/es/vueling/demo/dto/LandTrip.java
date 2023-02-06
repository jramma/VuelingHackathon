package es.vueling.demo.dto;

public class LandTrip extends Trip {

        public LandTrip(String name, String cities, String details, String duration) {
            super(name, cities, details, duration);
        }

        @Override
        String getType() {
            return "Land Trip";
        }
}
