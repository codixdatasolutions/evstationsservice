package com.ecosystem.evstationsservice.utility;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class CityMapping {
    private Map<String, String> cities = new HashMap<>();

    @JsonAnySetter
    public void setCity(String key, String value) {
        this.cities.put(key, value);
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }
}
