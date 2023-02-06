package es.vueling.demo.dto;

public abstract class Trip {

    private String name;
    private String cities;
    private String details;
    private String duration;

    public Trip(String name, String cities, String details, String duration) {
        this.name = name;
        this.cities = cities;
        this.details = details;
        this.duration = duration;
    }

    public Trip() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    abstract String getType();
}
